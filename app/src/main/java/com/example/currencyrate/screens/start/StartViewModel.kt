package com.example.currencyrate.screens.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyrate.data.repository.Repository
import com.example.currencyrate.model.nal.Nal
import kotlinx.coroutines.launch
import retrofit2.Response

class StartViewModel : ViewModel() {

    private var repo = Repository()
    val myMoneyList : MutableLiveData<Response<Nal>> = MutableLiveData()

    fun getNalMoney(){
        viewModelScope.launch {
            myMoneyList.value = repo.getNal()
        }
    }

}