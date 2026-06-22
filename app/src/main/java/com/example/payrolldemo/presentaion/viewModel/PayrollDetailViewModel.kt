package com.example.payrolldemo.presentaion.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.payrolldemo.domain.usecase.GetPayrollDetailUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class PayrollDetailViewModel(
    getPayrollDetailUseCase: GetPayrollDetailUseCase,
    payrollId: Long
) : ViewModel() {

    val payroll =
        getPayrollDetailUseCase(payrollId)
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                null
            )
}
