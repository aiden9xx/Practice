package com.example.testproject

import com.example.testproject.domain.entities.News
import com.example.testproject.domain.repositories.AuthenticationRepository
import retrofit2.Response

class LoginUseCase constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    suspend fun login(): Response<News> {
        return authenticationRepository.login()
    }
}