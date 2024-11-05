package com.example.moviesapp.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.DataSyncApp.REPOSITORY
import com.example.DataSyncApp.model.reader.ReaderItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    fun insert(nalItem: ReaderItem, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertReader(nalItem){
                onSuccess()
            }
        }

    fun delete(nalItem: ReaderItem, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteReader(nalItem){
                onSuccess()
            }
        }

}