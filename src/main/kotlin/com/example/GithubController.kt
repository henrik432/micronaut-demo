package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class GithubController {

    @Get("/ping")
    fun ping() = "pong"
}
