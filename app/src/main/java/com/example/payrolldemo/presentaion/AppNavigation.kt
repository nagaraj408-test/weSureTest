package com.example.payrolldemo.presentaion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.ui.platform.LocalContext
import com.example.payrolldemo.data.AppDatabase
import com.example.payrolldemo.data.remote.FakePayrollApi
import com.example.payrolldemo.data.repository.PayrollRepository
import com.example.payrolldemo.domain.usecase.CreatePayrollUseCase
import com.example.payrolldemo.domain.usecase.GetPayrollDetailUseCase
import com.example.payrolldemo.domain.usecase.GetPayrollsUseCase
import com.example.payrolldemo.presentaion.screens.CreatePayrollScreen
import com.example.payrolldemo.presentaion.screens.PayrollDetailScreen
import com.example.payrolldemo.presentaion.screens.PayrollListScreen
import com.example.payrolldemo.presentaion.viewModel.CreatePayrollViewModel
import com.example.payrolldemo.presentaion.viewModel.PayrollDetailViewModel
import com.example.payrolldemo.presentaion.viewModel.PayrollListViewModel

@Composable
fun AppNavigation() {

    val context = LocalContext.current
    val repository = remember {
        val database = AppDatabase.create(context)
        PayrollRepository(
            dao = database.payrollDao(),
            api = FakePayrollApi()
        )
    }

    val navController = rememberNavController()
    
    val getPayrollsUseCase = remember { GetPayrollsUseCase(repository) }
    val getPayrollDetailUseCase = remember { GetPayrollDetailUseCase(repository) }
    val createPayrollUseCase = remember { CreatePayrollUseCase(repository) }

    NavHost(
        navController = navController, startDestination = "payroll_list"
    ) {
        composable("payroll_list") {
            val viewModel = remember {
                PayrollListViewModel(getPayrollsUseCase)
            }
            val payrolls by viewModel.payrolls.collectAsState()

            PayrollListScreen(payrolls = payrolls, onCreatePayroll = {
                navController.navigate("create_payroll")
            }, onPayrollClick = { id ->
                navController.navigate("detail/$id")
            })
        }

        composable("create_payroll") {
            val viewModel = remember {
                CreatePayrollViewModel(createPayrollUseCase)
            }

            CreatePayrollScreen(
                addedEmployees = viewModel.employees,
                currentForm = viewModel.currentForm,
                onNameChange = viewModel::updateCurrentName,
                onWageChange = viewModel::updateCurrentWage,
                onExemptChange = viewModel::updateCurrentExempt,
                onAddEmployee = viewModel::addEmployee,
                onRemoveEmployee = viewModel::removeEmployee,
                onSave = {
                    viewModel.savePayroll()
                    navController.popBackStack()
                },
                onBack = {
                    navController.popBackStack()
                })
        }

        composable(
            route = "detail/{id}", arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                })
        ) { backStackEntry ->

            val payrollId = backStackEntry.arguments?.getLong("id") ?: 0L

            val viewModel = remember {
                PayrollDetailViewModel(
                    getPayrollDetailUseCase, payrollId
                )
            }

            val payroll by viewModel.payroll.collectAsState()

            payroll?.let {
                PayrollDetailScreen(
                    payroll = it, onBack = {
                        navController.popBackStack()
                    })
            }
        }
    }
}