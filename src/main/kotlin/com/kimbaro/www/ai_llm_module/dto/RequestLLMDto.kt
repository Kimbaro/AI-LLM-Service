package com.kimbaro.www.ai_llm_module.dto

data class RequestLLMDto(
    val key: String,
    val contents: List<Content>,
    val generationConfig: GenerationConfig
)

data class Content(
    val parts: List<Part>
)

data class Part(
    val text: String
)

data class GenerationConfig(
    val temperature: Double,
    val topK: Int,
    val topP: Double,
    val maxOutputTokens: Int,
    val responseMimeType: String
)