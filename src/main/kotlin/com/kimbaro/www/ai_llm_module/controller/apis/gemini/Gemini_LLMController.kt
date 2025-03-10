package com.kimbaro.www.ai_llm_module.controller.apis.gemini

import com.kimbaro.www.ai_llm_module.config.init.ThreadPoolAIWokerGroups
import com.kimbaro.www.ai_llm_module.domains.HELLORING_AI_TEXT
import com.kimbaro.www.ai_llm_module.dto.GeminiThreadData
import com.kimbaro.www.ai_llm_module.dto.Google_GeminiApiResponse
import com.kimbaro.www.ai_llm_module.dto.RequestLLMDto
import com.kimbaro.www.ai_llm_module.services.AIModelGroups
import org.springframework.context.ApplicationContext
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.WebSession

@RestController
@RequestMapping("/api/v1/gemini")
class Gemini_LLMController(
    private val threadPoolAIWokerGroups: ThreadPoolAIWokerGroups,
    private val applicationContext: ApplicationContext
) {

    @GetMapping("")
    fun getLLM(): String {
        return "returnCheck";
    }

    @PostMapping("/question")
    fun requestLLM(@RequestBody llmDTO: RequestLLMDto, session: WebSession): ResponseEntity<Google_GeminiApiResponse> {

//        threadPoolGroups.enqueue(GeminiThreadData(session,llmDTO))   <<- 비동기로 처리해야하는 경우

        val obj = applicationContext.getBean("HELLORING_AI_TEXT") as HELLORING_AI_TEXT
        return obj.execute(data = GeminiThreadData(session, llmDTO))
    }
}