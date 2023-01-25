package com.nik.smartapps.data.web

import android.util.Log
import com.nik.smartapps.data.UrlPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

class ServerRepository(private val serverPreference: UrlPreferences, private val api: ServerApi) {

    private var _serverKey: MutableStateFlow<Boolean> = MutableStateFlow(true)
    var serverKey: StateFlow<Boolean> = _serverKey

    suspend fun getValue(): Any = withContext(Dispatchers.IO) {

        var value = serverPreference.getResponse()

        if (value == null) {
            val result = api.getApi().id % 2 ==0
            serverPreference.setResponse(result)
            _serverKey.value = result
        } else {
            _serverKey.value = value
        }
    }
}