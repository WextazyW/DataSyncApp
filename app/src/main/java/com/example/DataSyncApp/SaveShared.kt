package com.example.DataSyncApp

import android.content.Context
import android.preference.PreferenceManager

@Suppress("DEPRECATION")
class SaveShared {
    companion object{
        fun setFavorite(context: Context ?= null, key : String, value : Boolean) {
            val setFavoriteShared = PreferenceManager.getDefaultSharedPreferences(context)
            setFavoriteShared.edit().putBoolean(key, value).apply()
        }
        fun getFavorite(context: Context ?= null, key : String) : Boolean {
            val getFavoriteShared = PreferenceManager.getDefaultSharedPreferences(context)
            return getFavoriteShared.getBoolean(key, false)
        }
    }
}