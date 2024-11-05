package com.example.DataSyncApp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.DataSyncApp.model.reader.ReaderItem

@Dao
interface ReaderDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(nalItem: ReaderItem)

    @Delete
    suspend fun delete(nalItem: ReaderItem)

    @Query("SELECT * FROM nal_table")
    fun getAllReaders() : LiveData<List<ReaderItem>>
}