package com.gang.lib_base

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object DataUtils {
    fun getString(context: Context, key: String): Flow<String> {
        val keys = preferencesKey<String>(key)
        val dataStore: DataStore<Preferences> = context.createDataStore(name = "DataStore")
        return dataStore.data.map {
            it[keys].toString()
        }
    }

    suspend fun setString(context: Context, key: String, value: String) {
        val keys = preferencesKey<String>(key)
        val dataStore: DataStore<Preferences> = context.createDataStore(name = "DataStore")
        dataStore.edit {
            it[keys] = value
        }
    }
}