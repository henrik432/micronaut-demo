package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller()
class GithubController(
    private val githubService: GithubService
) {

    @Get("/ping")
    fun ping() = "pong"

    @Get("/greeting")
    fun greeting() = "Hello ${githubService.getName()}"
}
