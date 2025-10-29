package com.example.loginmvvm.cleanllogin_without_api_di.presentation.loginwithoutapi_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.loginmvvm.cleanllogin_without_api_di.data.preference_manager.LoginPreference
import com.example.loginmvvm.cleanllogin_without_api_di.data.repository.AuthRepositoryImpl
import com.example.loginmvvm.cleanllogin_without_api_di.domain.usecase.LoginUsecase

import com.example.loginmvvm.cleanllogin_without_api_di.presentation.viewmodel.LoginNoAPIViewmodel
import com.example.loginmvvm.cleanllogin_without_api_di.presentation.viewmodel.ui.theme.LoginmvvmTheme

import com.example.loginmvvm.cleanllogin_without_api_di.presentation.MyViewModelFactory

class LoginWithoutAPIActivity : ComponentActivity() {
    private lateinit var viewModel: LoginNoAPIViewmodel

    val resp = AuthRepositoryImpl(LoginPreference)
    val f= LoginUsecase(resp)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val factory = MyViewModelFactory(f)
        viewModel = ViewModelProvider(this,factory).get(LoginNoAPIViewmodel::class.java)

        setContent {


                    Greeting(
                       viewModel

                        )

            }
        }

}

@Composable
fun Greeting(viewmodel: LoginNoAPIViewmodel) {

    var userName = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    Column() {
        TextField(
            value = userName.value,
            onValueChange = { it ->
                userName.value = it
            }
        )
        TextField(
            value = password.value,
            onValueChange = { it ->
                password.value = it
            }
        )
        Button(onClick = {
            viewmodel.getLogin(userName.value, password.value)
        }) {
            Text("click")
        }

    }
}
