package com.example.payrolldemo.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
data class EmployeeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val payrollId: Long,
    val name: String,
    val wages: Double,
    val exempt: Boolean
)