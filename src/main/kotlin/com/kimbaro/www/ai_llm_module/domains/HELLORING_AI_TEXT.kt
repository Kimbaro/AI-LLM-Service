package com.kimbaro.www.ai_llm_module.domains

import com.kimbaro.www.ai_llm_module.dto.GeminiThreadData
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component("HELLORING_AI_TEXT")
class HELLORING_AI_TEXT {
    private val log = LoggerFactory.getLogger(HELLORING_AI_TEXT::class.java)
    fun execute(data: GeminiThreadData): ResponseEntity<String> {
        log.info("ID : ${data.session.id}")
        log.info("DATA : ${data.data.toString()}")


        /*여기에서 gemini 요청부 구성*/



        return ResponseEntity.ok("sesssionId : ${data.session.id}\n data : ${data.data.toString()}");
    }
}