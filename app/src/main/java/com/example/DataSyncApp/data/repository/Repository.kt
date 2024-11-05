package com.example.DataSyncApp.data.repository

import com.example.DataSyncApp.data.api.RetrofitInstance
import com.example.DataSyncApp.model.reader.Reader
import retrofit2.Response

class Repository() {
    suspend fun getReader() : Response<Reader>{
        return RetrofitInstance.api.getReaders()
    }

}