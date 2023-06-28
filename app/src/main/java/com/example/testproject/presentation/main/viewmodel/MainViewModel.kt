package com.example.testproject.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.LoginUseCase
import com.example.testproject.data.model.Article
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import kotlinx.coroutines.launch

class MainViewModel constructor (
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _news = MutableLiveData<List<Article>>()
    val news: LiveData<List<Article>> = _news

    fun getArticles() {
        viewModelScope.launch {
            val login = loginUseCase.login()
            login.onSuccess {
                _news.value = data.articles
            }.onError {
                _news.value = mutableListOf()
            }.onException {

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}