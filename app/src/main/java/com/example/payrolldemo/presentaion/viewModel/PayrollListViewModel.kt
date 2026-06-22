package com.example.payrolldemo.presentaion.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.payrolldemo.data.repository.PayrollRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class PayrollListViewModel(
    repository: PayrollRepository
) : ViewModel() {

    val payrolls =
        repository.getPayrolls()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )
}