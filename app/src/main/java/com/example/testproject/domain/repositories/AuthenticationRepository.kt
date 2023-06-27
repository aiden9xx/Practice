package com.example.testproject.domain.repositories

interface AuthenticationRepository {
    fun login(): Boolean
    fun register()
}