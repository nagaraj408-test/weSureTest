package com.example.payrolldemo.domain.usecase

import com.example.payrolldemo.data.repository.PayrollRepository
import com.example.payrolldemo.domain.model.Employee

class CreatePayrollUseCase(
    private val repository: PayrollRepository
) {
    suspend operator fun invoke(employees: List<Employee>) {
        if (employees.isNotEmpty()) {
            repository.createPayroll(employees)
        }
    }
}
