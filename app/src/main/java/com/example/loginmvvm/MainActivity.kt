package com.example.loginmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.loginmvvm.simpleNavigation.AppNavigation
import com.example.loginmvvm.ui.theme.LoginmvvmTheme

class MainActivity : ComponentActivity() {
    private val loginViewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//cicd
        enableEdgeToEdge()
        setContent {
            LoginmvvmTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        loginViewModel = loginViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(loginViewModel: LoginViewModel, modifier: Modifier = Modifier) {
    val userDetails by loginViewModel.loginUser.collectAsState()
    val isLoggedIn by loginViewModel.isLoggedIn.collectAsState()
    val loginError by loginViewModel.loginError.collectAsState()
   // AppNavigation()
//    Column(
//        modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        if (isLoggedIn) {
//            Text("Welcome, ${userDetails?.username}!")
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = { loginViewModel.logout() }) {
//                Text("Logout")
//            }
//        } else {
//            var username = remember { mutableStateOf("") }
//            var password = remember { mutableStateOf("") }
//            TextField(
//                value = username.value,
//                onValueChange = { username.value = it},
//                label = { Text("Enter your name") },
//                singleLine = true,
//                modifier = Modifier.fillMaxWidth()
//
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            TextField(
//                value = password.value,
//                onValueChange = { password.value = it},
//                label = { Text("Enter your password") },
//                singleLine = true,
//                modifier = Modifier.fillMaxWidth()
//
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(
//                onClick = {
//                    loginViewModel.onUserLogin(username.value,password.value)
//                    loginViewModel.login()},
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text("Login")
//            }
//            loginError?.let { error ->
//                Text(text = error)
//            }
//        }
//    }
}
@Composable
fun Greeting() {
    val screenA = remember { mutableStateOf("a") }
    ScreenA(screenA.value)
}
@Composable
fun ScreenA( screenA: String)
{
    val screenA = remember { mutableStateOf(screenA) }
    Row()
    {
        Button(onClick = {screenA.value = "ScreenB"}) { Text("ScrrenB")}
    }

    if(screenA.value == "ScreenB")
    {
        ScreenB(screenA.value)
    }
}

@Composable
fun ScreenB(screenb:String)
{
    val screenB = remember { mutableStateOf(screenb) }
    val screenc = remember { mutableStateOf("") }
    Row()
    {
        Button(onClick = {screenB.value ="ScreenA"}) { Text("ScrrenA")}
        Button(onClick = {screenc.value ="ScreenC"}) { Text("ScrrenC")}
    }
    if(screenB.value =="ScreenA" ){
        ScreenA(screenB.value)
    }else if(screenc.value =="ScreenC" ){
        ScreenC(screenB.value)
    }
}
@Composable
fun ScreenC(screenc: String)
{
    val screenA = remember { mutableStateOf(screenc) }
    Row()
    {
        Button(onClick = {screenA.value =""}) { Text("ScrrenA")}
    }
    if(screenA.value =="screenA")
    {
        ScreenA(screenA.value)
    }
}