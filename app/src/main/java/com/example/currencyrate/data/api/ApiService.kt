package com.example.currencyrate.data.api

import com.example.currencyrate.model.beznal.BezNal
import com.example.currencyrate.model.beznal.BezNalItem
import com.example.currencyrate.model.nal.Nal
import com.example.currencyrate.model.nal.NalItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/Reader\n")
    suspend fun getNalMoney() : Response<Nal>

    @GET("api/Reader\n")
    suspend fun getBezNalMoney() : Response<BezNal>
}