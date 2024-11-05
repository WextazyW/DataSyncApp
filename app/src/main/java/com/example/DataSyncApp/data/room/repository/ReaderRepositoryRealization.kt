package com.example.DataSyncApp.data.room.repository

import androidx.lifecycle.LiveData
import com.example.DataSyncApp.data.room.dao.ReaderDao
import com.example.DataSyncApp.model.reader.ReaderItem

class ReaderRepositoryRealization(private val nalDao: ReaderDao) : ReaderRepository {

    override val allReader: LiveData<List<ReaderItem>>
        get() = nalDao.getAllReaders()

        override suspend fun insertReader(nal: ReaderItem, onSuccess: () -> Unit) {
        nalDao.insert(nal)
        onSuccess()
    }

    override suspend fun deleteReader(nal: ReaderItem, onSuccess: () -> Unit) {
        nalDao.delete(nal)
        onSuccess()
    }

}