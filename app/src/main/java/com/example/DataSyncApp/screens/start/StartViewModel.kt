package com.example.DataSyncApp.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.DataSyncApp.REPOSITORY
import com.example.DataSyncApp.data.repository.Repository
import com.example.DataSyncApp.data.room.ReaderRoomDataBase
import com.example.DataSyncApp.data.room.repository.ReaderRepositoryRealization
import com.example.DataSyncApp.model.reader.Reader
import kotlinx.coroutines.launch
import retrofit2.Response

class StartViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = Repository()
    val myMoneyList : MutableLiveData<Response<Reader>> = MutableLiveData()
    val context = application

    fun initDatabase(){
        val daoNal = ReaderRoomDataBase.getInstance(context).getNalDao()
        REPOSITORY = ReaderRepositoryRealization(daoNal)
    }

    fun getNalMoneyRetrofit(){
        viewModelScope.launch {
            myMoneyList.value = repo.getReader()
        }
    }

}