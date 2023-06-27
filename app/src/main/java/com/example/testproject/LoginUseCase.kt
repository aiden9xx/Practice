package com.example.testproject

import com.example.testproject.domain.repositories.AuthenticationRepository

class LoginUseCase constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    fun login(): Boolean {
        return authenticationRepository.login()
    }
}