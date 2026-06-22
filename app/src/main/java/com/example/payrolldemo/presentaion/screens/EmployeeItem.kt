package com.example.payrolldemo.presentaion.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.payrolldemo.presentaion.EmployeeForm

@Composable
fun EmployeeItem(
    employee: EmployeeForm,
    onNameChange: (String) -> Unit,
    onWageChange: (String) -> Unit,
    onExemptChange: (Boolean) -> Unit
) {
    Column {
        OutlinedTextField(
            value = employee.name,
            onValueChange = onNameChange,
            label = { Text("Employee Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = employee.wages, onValueChange = onWageChange, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ), label = { Text("Wages") }, modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = employee.exempt, onCheckedChange = onExemptChange
            )
            Text("Exempt")
        }

        HorizontalDivider()
        Spacer(modifier = Modifier.height(8.dp))
    }
}