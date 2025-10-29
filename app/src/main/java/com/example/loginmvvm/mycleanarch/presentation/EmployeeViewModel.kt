package com.example.loginmvvm.mycleanarch.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginmvvm.mycleanarch.core.common.UiState
import com.example.loginmvvm.mycleanarch.domain.model.Employee
import com.example.loginmvvm.mycleanarch.domain.usecase.GetEmployeeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(private val getEmployeeUseCase: GetEmployeeUseCase): ViewModel() {
    private val _employeeDetails = mutableStateOf(EmployeeState())
    val employeeDetails: State<EmployeeState> get() = _employeeDetails
    private val _employee = mutableStateOf(Employee())
    val employee: State<Employee> = _employee
    fun f()
    {
        viewModelScope.launch(){
            getEmployeeUseCase.invoke()
                .collect { it->
                    when(it){
                        is UiState.Success -> {
                            _employeeDetails.value = EmployeeState(data = it.data)
                        }
                        is UiState.Error -> {
                            _employeeDetails.value = EmployeeState(error = it.message.toString())
                        }
                        is UiState.Loading -> {
                            _employeeDetails.value = EmployeeState(isLoading = true                    )
                        }
                    }
                }
        }

    }
    init {
        getEmployeeUseCase.invoke().onEach {
            when(it){
                is UiState.Success -> {
                    _employeeDetails.value = EmployeeState(data = it.data)
                }
                is UiState.Error -> {
                    _employeeDetails.value = EmployeeState(error = it.message.toString())
                }
                is UiState.Loading -> {
                    _employeeDetails.value = EmployeeState(isLoading = true                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getEmployee( emp: Employee)
    {
        _employee.value = emp
    }
}