package com.example.payrolldemo.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.payrolldemo.data.local.entity.EmployeeEntity
import com.example.payrolldemo.data.local.entity.PayrollEntity
import com.example.payrolldemo.data.local.entity.PayrollWithEmployees
import kotlinx.coroutines.flow.Flow

@Dao
interface PayrollDao {

    @Insert
    suspend fun insertPayroll(
        payroll: PayrollEntity
    ): Long

    @Insert
    suspend fun insertEmployees(
        employees: List<EmployeeEntity>
    )

    @Transaction
    @Query("SELECT * FROM payrolls")
    fun getPayrolls(): Flow<List<PayrollWithEmployees>>

    @Transaction
    @Query("SELECT * FROM payrolls WHERE id=:id")
    fun getPayroll(
        id: Long
    ): Flow<PayrollWithEmployees>
}