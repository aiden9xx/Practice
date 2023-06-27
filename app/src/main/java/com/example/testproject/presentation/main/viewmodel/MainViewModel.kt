package com.example.testproject.presentation.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.common.utils.Utils
import com.example.testproject.LoginUseCase

class MainViewModel constructor (
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun testPrint() {
       val login = loginUseCase.login()
        Log.d("hailpt", " ===> Hair ${Utils.getValue()}")
    }

    override fun onCleared() {
        super.onCleared()
    }
}