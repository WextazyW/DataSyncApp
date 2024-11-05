package com.example.moviesapp.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.DataSyncApp.REPOSITORY
import com.example.DataSyncApp.model.reader.ReaderItem

class FavoriteFragmentViewModel : ViewModel() {
    fun getAllNal() : LiveData<List<ReaderItem>>{
        return REPOSITORY.allReader
    }
}