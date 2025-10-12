@file:Suppress("CAST_NEVER_SUCCEEDS")

package com.example.loginmvvm.mycleanarch.core.common


import com.example.loginmvvm.mycleanarch.data.model.EmployeeDTO
import com.example.loginmvvm.mycleanarch.domain.model.Address
import com.example.loginmvvm.mycleanarch.domain.model.Company
import com.example.loginmvvm.mycleanarch.domain.model.Employee

fun EmployeeDTO.toEmployeeList() : Employee{
    return Employee(id = this.id,name = this.name , username = this.username,
        email = this.email,address = this.address as Address,phone = this.phone,
        website = this.website,company = this.company as Company
        )
}
