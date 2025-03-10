package com.kimbaro.www.ai_llm_module.config.init

import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import feign.Logger;

@Configuration
class FeignConfig {
    @Bean
    fun feignHttpMessageConverters(): HttpMessageConverters {
        return HttpMessageConverters(MappingJackson2HttpMessageConverter())
    }

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL // 요청 및 응답에 대한 모든 로그
    }
}