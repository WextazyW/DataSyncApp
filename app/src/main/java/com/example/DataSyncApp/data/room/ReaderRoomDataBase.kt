package com.example.DataSyncApp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.DataSyncApp.data.room.dao.ReaderDao
import com.example.DataSyncApp.model.reader.ReaderItem

@Database(entities = [ReaderItem::class], version = 1)
abstract class ReaderRoomDataBase : RoomDatabase() {

    abstract fun getNalDao() : ReaderDao

    companion object{
        private var database : ReaderRoomDataBase ?= null

        fun getInstance(context: Context) : ReaderRoomDataBase {
            return if(database == null){
                database = Room
                    .databaseBuilder(context, ReaderRoomDataBase::class.java, "db")
                    .build()
                database as ReaderRoomDataBase
            } else{
                database as ReaderRoomDataBase
            }
        }
    }
}