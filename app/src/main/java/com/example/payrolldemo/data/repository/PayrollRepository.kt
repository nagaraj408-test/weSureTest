package com.example.payrolldemo.data.repository

import com.example.payrolldemo.data.local.dao.PayrollDao
import com.example.payrolldemo.data.local.entity.EmployeeEntity
import com.example.payrolldemo.data.local.entity.PayrollEntity
import com.example.payrolldemo.data.remote.PayrollApi
import com.example.payrolldemo.domain.model.Employee

class PayrollRepository(
    private val dao: PayrollDao,
    private val api: PayrollApi
) {
    fun getPayrolls() = dao.getPayrolls()

    fun getPayroll(id: Long) = dao.getPayroll(id)

    suspend fun createPayroll(
        employees: List<Employee>
    ) {
        api.syncPayroll()
        val payrollId = dao.insertPayroll(
            PayrollEntity(createdAt = System.currentTimeMillis())
        )

        dao.insertEmployees(
            employees.map {
                EmployeeEntity(
                    payrollId = payrollId,
                    name = it.name,
                    wages = it.wages,
                    exempt = it.exempt
                )
            })
    }
}