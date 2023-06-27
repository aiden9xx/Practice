package com.example.testproject.network

import com.example.testproject.data.model.Weather
import retrofit2.http.GET

interface ApiService {
    @GET("weather?q=Helsinki&units=metric")
    suspend fun getForecast(): Weather
}