package com.example.testproject

import com.example.testproject.domain.entities.News
import com.example.testproject.domain.repositories.AuthenticationRepository
import com.skydoves.sandwich.ApiResponse
import retrofit2.Response

class LoginUseCase constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend fun login(): ApiResponse<News> {
        return authenticationRepository.login()
    }
}