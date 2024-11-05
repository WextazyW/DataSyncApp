package com.example.DataSyncApp.data.api


import com.example.DataSyncApp.model.reader.Reader
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/Reader\n")
    suspend fun getReaders() : Response<Reader>

}