package com.example

import io.micronaut.context.annotation.Prototype
import io.micronaut.context.annotation.Value

@Prototype
open class GithubService(
    private val githubClient: GithubClient
) {

    @Value("\${github.token}")
    private lateinit var githubToken: String

    fun getName(): String {
        val authorization = "Bearer $githubToken"
        val viewerResponse = githubClient.getViewer(buildQuery(), authorization)
        return viewerResponse.data.viewer.login
    }

    private fun buildQuery() = """
        {
          viewer {
            login
          }
        }
    """.trimIndent()
}
