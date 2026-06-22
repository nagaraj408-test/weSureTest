package com.example.payrolldemo.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PayrollWithEmployees(
    @Embedded val payroll: PayrollEntity,

    @Relation(
        parentColumn = "id", entityColumn = "payrollId"
    ) val employees: List<EmployeeEntity>
)