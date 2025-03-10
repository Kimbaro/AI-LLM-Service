package com.kimbaro.www.ai_llm_module.services

import com.kimbaro.www.ai_llm_module.config.init.GeminiClient
import org.springframework.stereotype.Component

@Component
class AIModelGroups(private val geminiClient: GeminiClient) {
    fun getAIModelGroup(): GeminiClient {
        return geminiClient
    }
}