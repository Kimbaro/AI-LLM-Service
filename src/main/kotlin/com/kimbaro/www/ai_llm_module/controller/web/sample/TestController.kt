package com.kimbaro.www.ai_llm_module.controller.web.sample

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Controller
@RequestMapping("/test")
class TestController {
    @GetMapping
    fun home(): String {
        return "index"
    }
}