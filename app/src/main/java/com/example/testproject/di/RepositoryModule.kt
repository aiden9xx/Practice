package com.example.testproject.di

import com.example.testproject.data.AuthenticationRepositoryImpl
import com.example.testproject.domain.repositories.AuthenticationRepository
import org.koin.dsl.module


val repositoryModule = module {
    single<AuthenticationRepository> { AuthenticationRepositoryImpl(get())}
}