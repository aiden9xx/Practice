package com.example.testproject.data

import com.example.testproject.domain.entities.News
import com.example.testproject.domain.repositories.AuthenticationRepository
import com.example.testproject.network.ApiService
import com.skydoves.sandwich.ApiResponse
import retrofit2.Response

class AuthenticationRepositoryImpl constructor(
    private val apiService: ApiService
): AuthenticationRepository {
    override suspend fun login(): ApiResponse<News> {
        return apiService.getNews()
    }

    override suspend fun register() {
        // Todo
    }
}