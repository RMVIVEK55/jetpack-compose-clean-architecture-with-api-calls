package com.example.loginmvvm.simpleNavigation

import androidx.compose.foundation.layout.Column

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController


@Composable
fun FragmentB(navController: NavController,sharedViewModel: SharedViewModel) {
    val message = sharedViewModel.message.collectAsState()

    Column() {
        Text("FragmentB")
        Text("Received: ${message.value}")
        Button(onClick = {
            sharedViewModel.selectItem("Hello Fragment C")
            navController.navigate("fragmentC")}) { Text("Call FragmentC")}
    }
}
