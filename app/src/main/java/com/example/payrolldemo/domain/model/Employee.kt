package com.example.payrolldemo.domain.model

import com.example.payrolldemo.data.local.entity.EmployeeEntity

data class Employee(
    val name: String,
    val wages: Double,
    val exempt: Boolean
) {
    companion object {
        const val TAX_THRESHOLD = 1000.0
        const val TAX_RATE = 0.05
    }
    val taxes: Double
        get() = if (wages > TAX_THRESHOLD && !exempt)
            wages * TAX_RATE
        else
            0.0

    val net: Double
        get() = wages - taxes
}

fun EmployeeEntity.toDomain(): Employee {
    return Employee(
        name = name,
        wages = wages,
        exempt = exempt
    )
}
