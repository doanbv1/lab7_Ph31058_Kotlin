package com.ph31058.lab7_ph31058.component

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel () {
    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> =_password

    private val _rememberMe = MutableLiveData<Boolean>()
    val rememberMe: LiveData<Boolean> = _rememberMe

    private val _isAuthenticated = MutableLiveData<Boolean?>()
    val isAuthenticated: LiveData<Boolean?> = _isAuthenticated

    fun login (userName : String, passWord: String, rememberMe: Boolean){
        if (userName.equals("doandz") && passWord.equals("123")){
            _isAuthenticated.value = true
        }else{
            _isAuthenticated.value = false
        }
    }
    fun resetAuthenticationState() {
        _isAuthenticated.value = null
    }
}