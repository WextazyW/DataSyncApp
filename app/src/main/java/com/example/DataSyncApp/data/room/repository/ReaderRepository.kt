package com.example.DataSyncApp.data.room.repository

import androidx.lifecycle.LiveData
import com.example.DataSyncApp.model.reader.ReaderItem

interface ReaderRepository {
    val allReader : LiveData<List<ReaderItem>>
    suspend fun insertReader(nal : ReaderItem, onSuccess:() -> Unit)
    suspend fun deleteReader(nal : ReaderItem, onSuccess:() -> Unit)
}