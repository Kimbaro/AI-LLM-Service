package com.kimbaro.www.ai_llm_module

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class AiLlmModuleApplication

fun main(args: Array<String>) {
    runApplication<AiLlmModuleApplication>(*args)
}
