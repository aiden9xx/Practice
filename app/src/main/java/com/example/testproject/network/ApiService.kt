package com.example.testproject.network

import com.example.testproject.domain.entities.News
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("top-headlines")
    suspend fun getNews(): Response<News>

    companion object {
        const val NEWS_API_URL = "https://newsapi.org/v2/"
    }
}