package com.muammarahlnn.lsv.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.muammarahlnn.lsv.datastore.model.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LsvPreferencesDataSource, 30/03/2024 19.14
 */

val Context.lsvPreferences: DataStore<Preferences> by preferencesDataStore("lsvPreferences")

class LsvPreferencesDataSource @Inject constructor(
    private val preferences: DataStore<Preferences>
) {

    private object PreferencesKeys {

        val ID = stringPreferencesKey("id")

        val TOKEN = stringPreferencesKey("token")

        val FULL_NAME = stringPreferencesKey("full_name")

        val USERNAME = stringPreferencesKey("username")

        val ROLE = stringPreferencesKey("role")
    }

    suspend fun saveUser(user: UserEntity) {
        preferences.edit { pref ->
            pref[PreferencesKeys.ID] = user.id
            pref[PreferencesKeys.FULL_NAME] = user.fullName
            pref[PreferencesKeys.USERNAME] = user.username
            pref[PreferencesKeys.ROLE] = user.role
        }
    }

    suspend fun removeUser() {
        preferences.edit { pref ->
            pref[PreferencesKeys.ID] = ""
            pref[PreferencesKeys.TOKEN] = ""
            pref[PreferencesKeys.FULL_NAME] = ""
            pref[PreferencesKeys.USERNAME] = ""
            pref[PreferencesKeys.ROLE] = ""
        }
    }

    fun getUser(): Flow<UserEntity> =
        preferences.data.map { pref ->
            UserEntity(
                id = pref[PreferencesKeys.ID] ?: "",
                username = pref[PreferencesKeys.USERNAME] ?: "",
                fullName = pref[PreferencesKeys.FULL_NAME] ?: "",
                role = pref[PreferencesKeys.ROLE] ?: "",
            )
        }

    suspend fun saveAccessToken(accessToken: String) {
        preferences.edit { pref ->
            pref[PreferencesKeys.TOKEN] = accessToken
        }
    }

    fun getAccessToken(): Flow<String> =
        preferences.data.map { pref ->
            pref[PreferencesKeys.TOKEN] ?: ""
        }

}