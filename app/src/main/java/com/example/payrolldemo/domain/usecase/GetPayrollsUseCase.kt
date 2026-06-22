package com.example.payrolldemo.domain.usecase

import com.example.payrolldemo.data.repository.PayrollRepository
import com.example.payrolldemo.domain.model.Payroll
import com.example.payrolldemo.domain.model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetPayrollsUseCase(
    private val repository: PayrollRepository
) {
    operator fun invoke(): Flow<List<Payroll>> {
        return repository.getPayrolls().map { list ->
            list.map { it.toDomain() }
        }
    }
}
