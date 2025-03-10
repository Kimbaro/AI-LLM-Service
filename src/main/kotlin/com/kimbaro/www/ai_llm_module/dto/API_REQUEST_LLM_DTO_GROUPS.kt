package com.kimbaro.www.ai_llm_module.dto

data class RequestLLMDto(
    val model: String,
    val key: String,
    val contents: List<RequestLLMDto_Content>,
    val generationConfig: RequestLLMDto_GenerationConfig
)

data class RequestLLMDto_Content(
    val parts: List<RequestLLMDto_Content_Part>
)

data class RequestLLMDto_Content_Part(
    val text: String
)

data class RequestLLMDto_GenerationConfig(
    val temperature: Double,
    val topK: Int,
    val topP: Double,
    val maxOutputTokens: Int,
    val responseMimeType: String
)