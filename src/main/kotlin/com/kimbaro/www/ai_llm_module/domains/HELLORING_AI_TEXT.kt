package com.kimbaro.www.ai_llm_module.domains

import com.kimbaro.www.ai_llm_module.config.init.GeminiClient
import com.kimbaro.www.ai_llm_module.dto.*
import com.kimbaro.www.ai_llm_module.services.AIModelGroups
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Component("HELLORING_AI_TEXT")
class HELLORING_AI_TEXT(private val aiModelGroups: AIModelGroups) {

    private val log = LoggerFactory.getLogger(HELLORING_AI_TEXT::class.java)

    fun execute(data: GeminiThreadData): ResponseEntity<Google_GeminiApiResponse> {
        log.info("SESSION-ID : ${data.session.id}")
        log.info("DATA-ID : ${data.data.model}")
        log.info("DATA-DATA : ${data.data.toString()}")


        /*여기에서 gemini 요청부 구성*/
        val geminiClient: GeminiClient = aiModelGroups.getAIModelGroup();
        // => 요청 바디 컨버팅
        val contents = data.data.contents.map { content ->
            Google_GenerateContentDTO_Content(parts = content.parts.map { part ->
                Google_GenerateContentDTO_Content_Part(
                    text = part.text
                )
            })
        }
        val generationConfig = Google_GenerateContentDTO_GenerationConfig(
            temperature = data.data.generationConfig.temperature,
            topK = data.data.generationConfig.topK,
            topP = data.data.generationConfig.topP,
            maxOutputTokens = data.data.generationConfig.maxOutputTokens,
            responseMimeType = data.data.generationConfig.responseMimeType
        )

        val res = geminiClient.generateContent(
            data.data.model,
            data.data.key,
            Google_GenerateContentDTO(contents, generationConfig)
        )
        log.info("RES : ${res.toString()}")

        return ResponseEntity.ok(res);
    }
}