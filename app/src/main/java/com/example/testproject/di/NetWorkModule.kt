package com.example.testproject.di
import com.example.testproject.network.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import com.example.testproject.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { ApiService }
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(ApiService.NEWS_API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideForecastApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url().newBuilder().
        addQueryParameter("apiKey", BuildConfig.NEWS_API_KEY).
        addQueryParameter("country", BuildConfig.NEWS_COUNTRY_CODE)
            .build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}
