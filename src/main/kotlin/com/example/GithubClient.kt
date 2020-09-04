package com.example

import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

@Client("https://api.github.com/graphql")
interface GithubClient {

    @Post
    fun getViewer(query: String, @Header authorization: String, @Header("User-Agent") userAgent: String = "devconf2020"): ViewerResponse
}
