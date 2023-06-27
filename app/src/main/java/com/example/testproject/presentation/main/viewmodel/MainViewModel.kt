package com.example.testproject.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.LoginUseCase
import com.example.testproject.data.model.Article
import kotlinx.coroutines.launch

class MainViewModel constructor (
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _news = MutableLiveData<List<Article>>()
    val news: LiveData<List<Article>> = _news

    fun getArticles() {
        viewModelScope.launch {
            val login = loginUseCase.login()
            when(login.body()?.status) {
                "ok" -> {
                    _news.value = login.body()?.articles
                }
                else -> {
                    _news.value = mutableListOf()
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}