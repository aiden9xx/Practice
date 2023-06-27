package com.example.testproject.presentation.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.utils.Utils
import com.example.testproject.LoginUseCase
import kotlinx.coroutines.launch

class MainViewModel constructor (
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun testPrint() {
        viewModelScope.launch {
            val login = loginUseCase.login()
            Log.d("hailpt", " ===> Hair ${Utils.getValue()}")
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}