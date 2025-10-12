package com.example.loginmvvm.mycleanarch.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginmvvm.mycleanarch.utils.Constant

@Composable
fun EmpAppNavigationHost() {
    val navController = rememberNavController()
    Column(modifier = Modifier.padding(top = 50.dp)) {
        NavHost(
            navController = navController,
            startDestination = Constant.EMP_LIST_SCREEN
        ) {
            composable(Constant.EMP_LIST_SCREEN) {
                EmployeeListScreenUI(navController)
            }
            composable(Constant.EMP_SCREEN) {
                EmployeeDetails(navController)
            }

        }
    }

}

