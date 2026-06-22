package com.example.payrolldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.payrolldemo.data.AppDatabase
import com.example.payrolldemo.data.remote.FakePayrollApi
import com.example.payrolldemo.data.repository.PayrollRepository
import com.example.payrolldemo.presentaion.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val database = AppDatabase.create(this)
        val repository = PayrollRepository(
            dao = database.payrollDao(), api = FakePayrollApi()
        )
        setContent {
            AppNavigation(repository)
        }
    }

}