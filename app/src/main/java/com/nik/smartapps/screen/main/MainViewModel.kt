package com.nik.smartapps.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nik.smartapps.data.web.ServerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ServerRepository) : ViewModel() {
    val token = repository.serverKey

    fun start() {
        viewModelScope.launch(Dispatchers.Default) { repository.getValue() }
    }
}