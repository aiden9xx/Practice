package com.example.testproject.domain.repositories

import com.example.testproject.domain.entities.News
import com.skydoves.sandwich.ApiResponse
import retrofit2.Response

interface AuthenticationRepository {
    suspend fun login(): ApiResponse<News>
    suspend fun register()
}