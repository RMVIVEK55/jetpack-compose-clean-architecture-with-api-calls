package com.example.loginmvvm.simpleNavigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController


@Composable
fun FragmentA(navController: NavController, sharedViewModel: SharedViewModel) {
    val message = sharedViewModel.message.collectAsState()
    Column {
        Button(onClick = {
            if(message.value.isEmpty()) {
                sharedViewModel.selectItem("Hello Fragment B")
                navController.navigate("fragmentB")
            }else{
                navController.currentDestination
            }
        }) {
            Text(if(message.value.isEmpty()) "Call FragmentB" else "Bye FragmentC")
        }

    }
    BackHandler {
        if(message.value.isNotEmpty()) {
            navController.currentDestination
        }
    }
}
