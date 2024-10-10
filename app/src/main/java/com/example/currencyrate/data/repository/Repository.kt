package com.example.currencyrate.data.repository

import com.example.currencyrate.data.api.RetrofitInstance
import com.example.currencyrate.model.beznal.BezNal
import com.example.currencyrate.model.beznal.BezNalItem
import com.example.currencyrate.model.nal.Nal
import com.example.currencyrate.model.nal.NalItem
import retrofit2.Response

class Repository() {
    suspend fun getNal() : Response<Nal>{
        return RetrofitInstance.api.getNalMoney()
    }
    suspend fun getBeznal() : Response<BezNal>{
        return RetrofitInstance.api.getBezNalMoney()
    }
}