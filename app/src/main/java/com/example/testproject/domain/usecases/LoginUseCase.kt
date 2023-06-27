package com.example.testproject.domain.usecases

import com.example.testproject.domain.repositories.AuthenticationRepository

class LoginUseCase constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend fun login() {
        authenticationRepository.login()
    }
}