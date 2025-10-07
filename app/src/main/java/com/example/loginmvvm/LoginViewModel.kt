package com.example.loginmvvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {

    private var _loginError = MutableStateFlow<String?>("")
    var  loginError: StateFlow<String?> = _loginError.asStateFlow()

    private var _loginUser = MutableStateFlow<User?>(null)
    var  loginUser: StateFlow<User?> = _loginUser.asStateFlow()

    private var _isLoggedIn = MutableStateFlow<Boolean>(false)
    var  isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    fun onUserLogin( newUsername: String,newPassword: String) {
        _loginUser.value = User(newUsername,newPassword)
    }

    fun login() {
        when{
            _loginUser.value?.username.isNullOrEmpty() && _loginUser.value?.password.isNullOrEmpty() -> {
                _loginError.value = "Invalid username or password"
            }
            _loginUser.value?.username.isNullOrEmpty() -> {
                _loginError.value = "Please enter username"
            }
            _loginUser.value?.password.isNullOrEmpty() -> {
                _loginError.value = "Please enter password"
            }
            _loginUser.value?.username == "user" && _loginUser.value?.password == "password" -> {
                _isLoggedIn.value = true
                _loginError.value = null
            }
        }
    }

    fun logout() {
        _isLoggedIn.value = false
        _loginUser.value = null
        _loginError.value = null
    }
}