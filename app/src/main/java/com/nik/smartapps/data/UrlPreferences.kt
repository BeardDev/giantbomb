package com.nik.smartapps.data

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

private const val Response_KEY = "key"

@Singleton
class UrlPreferences @Inject constructor(@ApplicationContext context : Context) {
    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    fun getResponse(): Boolean? {

        val isExist = prefs.contains(Response_KEY)

        if (isExist)
        {
            val value = prefs.getBoolean(Response_KEY, false)
            Log.d("UrlPreferences", "return value $value")
            return value
        }
        else
        {
            return null
        }
    }

    fun setResponse(value: Boolean) {
        prefs.edit {
            putBoolean(Response_KEY, value)
            commit()
            Log.d("UrlPreferences", "new value $value")
        }
    }
}

