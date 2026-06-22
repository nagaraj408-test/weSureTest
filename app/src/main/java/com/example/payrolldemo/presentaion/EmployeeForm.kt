package com.example.payrolldemo.presentaion

import java.util.UUID

data class EmployeeForm(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "",
    val wages: String = "",
    val exempt: Boolean = false
)