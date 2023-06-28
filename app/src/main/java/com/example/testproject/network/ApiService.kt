package com.example.testproject.network

import com.example.testproject.domain.entities.News
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("top-headlines")
    suspend fun getNews(): ApiResponse<News>

    companion object {
        const val NEWS_API_URL = "https://newsapi.org/v2/"
    }
}