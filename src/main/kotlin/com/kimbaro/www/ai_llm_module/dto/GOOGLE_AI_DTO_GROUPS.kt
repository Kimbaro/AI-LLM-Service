package com.kimbaro.www.ai_llm_module.dto

data class Google_GenerateContentDTO(
    val contents: List<Google_GenerateContentDTO_Content>,
    val generationConfig: Google_GenerateContentDTO_GenerationConfig
)

data class Google_GenerateContentDTO_Content(
    val parts: List<Google_GenerateContentDTO_Content_Part>
)

data class Google_GenerateContentDTO_Content_Part(
    val text: String
)

data class Google_GenerateContentDTO_GenerationConfig(
    val temperature: Double,
    val topK: Int,
    val topP: Double,
    val maxOutputTokens: Int,
    val responseMimeType: String
)
