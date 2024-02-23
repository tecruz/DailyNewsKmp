package com.example.dailynews.sources.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(private val httpClient: HttpClient) {
    private val apiKey = "YourApiKey"

    suspend fun fetchSources(): List<SourceRaw> {
        val response: SourcesResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey")
                .body()
        return response.sources
    }
}