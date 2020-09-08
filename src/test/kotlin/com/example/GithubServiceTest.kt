package com.example

import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import javax.inject.Inject

@MicronautTest
@ExtendWith(MockitoExtension::class)
internal class GithubServiceTest {

    @Inject
    lateinit var githubService: GithubService

    @Mock
    lateinit var githubClient: GithubClient

    @Test
    fun shouldReturnName() {
        given(githubClient.getViewer(anyString(), anyString(), anyString()))
            .willReturn(givenViewerResponse())

        val name = githubService.getName()

        assertEquals("John Doe", name)
    }

    private fun givenViewerResponse(): ViewerResponse = ViewerResponse(Data(Viewer("John Doe")))

    @MockBean(GithubClient::class)
    fun mockGithubClient() = githubClient
}
