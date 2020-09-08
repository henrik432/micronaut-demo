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
        val viewerResponse = githubClient.getViewer(VIEWER_QUERY, "Bearer $githubToken")
        return viewerResponse.data.viewer.login
    }

}

private const val VIEWER_QUERY = """
{
  viewer {
    login
  }
}
"""
