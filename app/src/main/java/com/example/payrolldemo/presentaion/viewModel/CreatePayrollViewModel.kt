package com.example.payrolldemo.presentaion.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.payrolldemo.domain.model.Employee
import com.example.payrolldemo.domain.usecase.CreatePayrollUseCase
import com.example.payrolldemo.presentaion.EmployeeForm
import kotlinx.coroutines.launch

class CreatePayrollViewModel(
    private val createPayrollUseCase: CreatePayrollUseCase
) : ViewModel() {
    var employees by mutableStateOf(
        emptyList<EmployeeForm>()
    )
        private set

    var currentForm by mutableStateOf(EmployeeForm())
        private set

    fun addEmployee() {
        if (currentForm.name.isNotBlank() && currentForm.wages.isNotBlank()) {
            employees = employees + currentForm
            currentForm = EmployeeForm()
        }
    }

    fun updateCurrentName(value: String) {
        currentForm = currentForm.copy(name = value)
    }

    fun updateCurrentWage(value: String) {
        currentForm = currentForm.copy(wages = value)
    }

    fun updateCurrentExempt(value: Boolean) {
        currentForm = currentForm.copy(exempt = value)
    }

    fun removeEmployee(id: String) {
        employees = employees.filter { it.id != id }
    }

    fun savePayroll() {
        viewModelScope.launch {
            val allEmployees = employees.toMutableList()
            if (currentForm.name.isNotBlank() && currentForm.wages.isNotBlank()) {
                allEmployees.add(currentForm)
            }

            if (allEmployees.isNotEmpty()) {
                createPayrollUseCase(
                    allEmployees.map {
                        Employee(
                            name = it.name,
                            wages = it.wages.toDoubleOrNull() ?: 0.0,
                            exempt = it.exempt
                        )
                    })
            }
        }
    }
}
