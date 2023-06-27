package com.example.testproject.data

import com.example.testproject.domain.repositories.AuthenticationRepository

class AuthenticationRepositoryImpl: AuthenticationRepository {
    override fun login(): Boolean {
        return true
    }

    override fun register() {
        // Todo
    }
}