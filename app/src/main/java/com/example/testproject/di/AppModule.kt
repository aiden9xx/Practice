package com.example.testproject.di

import com.example.testproject.presentation.main.viewmodel.MainViewModel
import com.example.testproject.LoginUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::MainViewModel)
    singleOf(::LoginUseCase)
//    single { MainViewModel(loginUseCase = get()) }

}