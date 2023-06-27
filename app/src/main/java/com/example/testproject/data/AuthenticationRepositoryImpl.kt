package com.example.testproject.data

import com.example.testproject.domain.entities.News
import com.example.testproject.domain.repositories.AuthenticationRepository
import com.example.testproject.network.ApiService
import retrofit2.Response

class AuthenticationRepositoryImpl constructor(
    private val apiService: ApiService
): AuthenticationRepository {
    override suspend fun login(): Response<News> {
        return apiService.getNews()
    }

    override suspend fun register() {
        // Todo
    }
}