package com.reverchen.githubuserlist_exercise.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SealRetrofit {
    
    private val baseUrl = "https://api.github.com"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    
    fun build(): Retrofit {
        return retrofit
    }
}