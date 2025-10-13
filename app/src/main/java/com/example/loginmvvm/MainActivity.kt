package com.example.loginmvvm


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.loginmvvm.mycleanarch.presentation.EmpAppNavigationHost

import com.example.loginmvvm.ui.theme.LoginmvvmTheme
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(application, "ccb32053-0aef-472a-9852-9cf9a5cc17b5",
            Analytics::class.java, Crashes::class.java)
        enableEdgeToEdge()
        setContent {
            LoginmvvmTheme {
                               Analytics.trackEvent("called MainActivity")
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

    val shortWords : MutableList<String> = mutableListOf<String>()
    shortWords.add("")
   // AppNavigation()//
   // HomeScreen()
    EmpAppNavigationHost()
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
