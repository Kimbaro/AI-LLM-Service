package com.kimbaro.www.ai_llm_module.dto

import org.springframework.web.server.WebSession

data class GeminiThreadData(
    val session: WebSession,
    val data: RequestLLMDto
)