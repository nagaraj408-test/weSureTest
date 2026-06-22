package com.example.payrolldemo.data.remote

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class FakePayrollApi : PayrollApi {
    override suspend fun syncPayroll() {
        delay(500.milliseconds)
    }
}