package com.example.DataSyncApp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.0.17:7124/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}