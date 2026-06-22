package com.example.payrolldemo.presentaion.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.payrolldemo.domain.usecase.GetPayrollsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class PayrollListViewModel(
    getPayrollsUseCase: GetPayrollsUseCase
) : ViewModel() {

    val payrolls =
        getPayrollsUseCase()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )
}
