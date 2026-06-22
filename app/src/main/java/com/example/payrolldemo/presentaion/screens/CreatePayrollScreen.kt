package com.example.payrolldemo.presentaion.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.payrolldemo.domain.model.Employee
import com.example.payrolldemo.presentaion.EmployeeForm

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePayrollScreen(
    addedEmployees: List<EmployeeForm>,
    currentForm: EmployeeForm,
    onNameChange: (String) -> Unit,
    onWageChange: (String) -> Unit,
    onExemptChange: (Boolean) -> Unit,
    onAddEmployee: () -> Unit,
    onRemoveEmployee: (String) -> Unit,
    onSave: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                Text(
                    "New Payroll", fontWeight = FontWeight.Bold
                )
            }, navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
            )
        }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = "Add Employees",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    EmployeeItem(
                        employee = currentForm,
                        onNameChange = onNameChange,
                        onWageChange = onWageChange,
                        onExemptChange = onExemptChange
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = onAddEmployee,
                        modifier = Modifier.fillMaxWidth(),
                        enabled = currentForm.name.isNotBlank() && currentForm.wages.isNotBlank()
                    ) {
                        Text("Add to List")
                    }
                }
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            Text(
                text = "Payroll List (${addedEmployees.size})",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            LazyColumn(
                modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = addedEmployees, key = { it.id }) { employee ->
                    AddedEmployeeItem(
                        employee = employee, onRemove = { onRemoveEmployee(employee.id) })
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onSave,
                modifier = Modifier.fillMaxWidth(),
                enabled = addedEmployees.isNotEmpty() || (currentForm.name.isNotBlank() && currentForm.wages.isNotBlank()),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    "Create Payroll",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
fun AddedEmployeeItem(
    employee: EmployeeForm, onRemove: () -> Unit
) {
    val domainEmployee = Employee(
        name = employee.name,
        wages = employee.wages.toDoubleOrNull() ?: 0.0,
        exempt = employee.exempt
    )

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = employee.name, style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Gross: ${employee.wages}${if (employee.exempt) " (Exempt)" else ""}",
                    style = MaterialTheme.typography.bodySmall
                )
                if (domainEmployee.taxes > 0) {
                    Text(
                        text = "Net: ${domainEmployee.net} (Tax: ${domainEmployee.taxes})",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            IconButton(onClick = onRemove) {
                Icon(
                    imageVector = Icons.Default.Delete, contentDescription = "Remove"
                )
            }
        }
    }
}
