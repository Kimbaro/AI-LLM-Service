package com.kimbaro.www.ai_llm_module.config.init

import com.kimbaro.www.ai_llm_module.dto.Google_GeminiApiResponse
import com.kimbaro.www.ai_llm_module.dto.Google_GenerateContentDTO
import feign.Headers
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "googleGeminiRequestClient", url = "https://generativelanguage.googleapis.com")
interface GeminiClient {

    @PostMapping("/v1beta/models/{model}:generateContent?key={key}")
    @Headers("Content-Type: application/json;charset=UTF-8")
    fun generateContent(
        @PathVariable("model") model: String,
        @PathVariable("key") key: String,
        @RequestBody body: Google_GenerateContentDTO
    ):Google_GeminiApiResponse
}

