package com.example.loginmvvm.simpleNavigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class SharedViewModel : ViewModel() {
    private val _message = MutableStateFlow<String>("")
    val message: StateFlow<String> = _message.asStateFlow()

    fun selectItem(msg: String) {
        _message.value = msg
    }
}
