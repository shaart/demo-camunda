package com.github.shaart.demo.camunda.controller

import com.github.shaart.demo.camunda.dto.ResponseDto
import com.github.shaart.demo.camunda.logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

    private val log = logger()

    @GetMapping
    fun getAll(): ResponseDto {
        log.info("Got request for getAll()")
        return ResponseDto("test")
    }
}