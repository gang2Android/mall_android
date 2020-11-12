package com.gang.module_base

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

object DataUtils {

    val KEY_WEI_BO = preferencesKey<Boolean>("weibo")
    var dataStore: DataStore<Preferences>? = null

    fun init(context: Context, fileName: String = "USER_PREFERENCES_NAME") {
        dataStore = context.applicationContext.createDataStore(
            name = fileName, migrations = listOf(
                SharedPreferencesMigration(context.applicationContext, fileName)
            )
        )
    }

    suspend fun save(
        key: Preferences.Key<Boolean>
    ) {

        dataStore?.edit { mutablePreferences ->
            val value = mutablePreferences[key] ?: false
            mutablePreferences[key] = !value
        }
    }

    fun read(
        key: Preferences.Key<Boolean>
    ): LiveData<Boolean> {
        val data =  dataStore?.data!!.catch {
            // 当读取数据遇到错误时，如果是 `IOException` 异常，发送一个 emptyPreferences 来重新使用
            // 但是如果是其他的异常，最好将它抛出去，不要隐藏问题
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map { preferences ->
            preferences[key] ?: false
        }
        return data.asLiveData()
    }
}