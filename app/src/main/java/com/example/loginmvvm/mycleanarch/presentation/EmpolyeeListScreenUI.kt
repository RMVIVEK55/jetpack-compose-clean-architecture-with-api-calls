package com.example.loginmvvm.mycleanarch.presentation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.loginmvvm.mycleanarch.utils.Constant


@Composable
fun EmployeeListScreenUI(navController: NavController){
  val viewModel : EmployeeViewModel = hiltViewModel()
    val result = viewModel.employeeDetails.value
    Log.e("vivek","${result.data}")
    result.data?.let {
      val interactionSource = remember { MutableInteractionSource() }
        LazyColumn {
          itemsIndexed(items = result.data) { index, item ->
            Card (modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
              colors = CardDefaults.cardColors(containerColor = Color.White),
              elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
              Row(modifier = Modifier.padding(10.dp), horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = item.username?:"",  modifier = Modifier.clickable(interactionSource = interactionSource , indication = null) {
                  viewModel.getEmployee(item)
                  navController.navigate(Constant.EMP_SCREEN)
                })
              }
            }


          }
        }


    }
}