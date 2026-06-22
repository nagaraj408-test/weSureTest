package com.example.payrolldemo.data.model

import com.example.payrolldemo.data.local.entity.PayrollWithEmployees

data class Payroll(
    val id: Long,
    val createdAt: Long,
    val employees: List<Employee>
) {
    val totalGross: Double get() = employees.sumOf { it.wages }
    val totalTaxes: Double get() = employees.sumOf { it.taxes }
    val totalNet: Double get() = employees.sumOf { it.net }
}

fun PayrollWithEmployees.toDomain(): Payroll {
    return Payroll(
        id = payroll.id,
        createdAt = payroll.createdAt,
        employees = employees.map { it.toDomain() }
    )
}