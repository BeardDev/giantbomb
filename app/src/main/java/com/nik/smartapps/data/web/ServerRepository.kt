package com.nik.smartapps.data.web

import android.util.Log
import com.nik.smartapps.data.ResponseSharedPreference
import com.nik.smartapps.data.entity.Server
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

class ServerRepository(private val serverPreference: ResponseSharedPreference, private val api: ServerApi) {

    private var _serverKey: MutableStateFlow<Boolean> = MutableStateFlow(true)
    var serverKey: StateFlow<Boolean> = _serverKey

    suspend fun getApii(): Any = withContext(Dispatchers.IO) {

        var value = serverPreference.getResponse()
        Log.d("NikitaKaretnikov","${value}")

        if (value == null) {
            Log.e("ServerRepository", "getResponse error")
            val result = api.getApi().id % 2 ==0
            Log.d("NikitaKaretnikov","ebat")
            serverPreference.setResponse(result)
            _serverKey.value = result
        } else {
            _serverKey.value = value
            Log.d("NikitaKaretnikov","ebat")
        }
    }
}