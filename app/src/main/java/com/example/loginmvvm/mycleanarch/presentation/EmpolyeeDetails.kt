package com.example.loginmvvm.mycleanarch.presentation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.loginmvvm.mycleanarch.utils.Constant

@Composable
fun EmployeeDetails(navController: NavController) {
    val viewModel : EmployeeViewModel = hiltViewModel()
    val employee = viewModel.employee.value
    val interactionSource = remember { MutableInteractionSource() }
    Log.e("vivek","${employee}")
    Card (modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
        Column(modifier  = Modifier.clickable(interactionSource = interactionSource , indication = null) {
            navController.navigate(Constant.EMP_LIST_SCREEN)
        }.padding(10.dp)) {
            Text("${employee.phone}")
            Text("${employee.email}")
            Text("${employee.address}")
        }




    }

}