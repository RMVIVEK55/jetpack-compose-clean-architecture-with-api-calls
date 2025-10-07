package com.example.loginmvvm.simpleNavigation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigation(sharedViewModel: SharedViewModel = viewModel()) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Column(modifier = Modifier.padding(top = 50.dp)) {
        NavHost(
            navController = navController,
            startDestination = "fragmentA"
        ) {
            composable("fragmentA") {
                FragmentA(navController, sharedViewModel)
            }
            composable("fragmentB") {
                FragmentB(navController, sharedViewModel)
            }
            composable("fragmentC") {
                FragmentC(navController, sharedViewModel)
            }
        }
    }
    val destinations = navBackStackEntry?.destination?.route
    Log.e("TAG","${destinations}")//print back stack of fragment
}

