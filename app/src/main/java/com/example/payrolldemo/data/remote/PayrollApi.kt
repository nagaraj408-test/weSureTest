package com.example.payrolldemo.data.remote

interface PayrollApi {
    suspend fun syncPayroll()
}