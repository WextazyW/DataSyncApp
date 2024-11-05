package com.example.DataSyncApp.model.reader

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "nal_table")
class ReaderItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo
    val firstName: String?,
    @ColumnInfo
    val lastName: String?,
    @ColumnInfo
    val contactDetails: Int,
) : Serializable