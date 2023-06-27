package com.example.testproject.domain.repositories

import com.example.testproject.domain.entities.News
import retrofit2.Response

interface AuthenticationRepository {
    suspend fun login(): Response<News>
    suspend fun register()
}