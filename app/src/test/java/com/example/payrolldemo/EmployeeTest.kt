package com.example.payrolldemo

import com.example.payrolldemo.domain.model.Employee
import org.junit.Assert.assertEquals
import org.junit.Test

class EmployeeTest {

    @Test
    fun `tax is 5 percent when wages greater than 1000 and not exempt`() {
        val employee = Employee(name = "Test", wages = 2000.0, exempt = false)
        assertEquals(100.0, employee.taxes, 0.001)
        assertEquals(1900.0, employee.net, 0.001)
    }

    @Test
    fun `tax is zero when wages exactly 1000 and not exempt`() {
        val employee = Employee(name = "Test", wages = 1000.0, exempt = false)
        assertEquals(0.0, employee.taxes, 0.001)
        assertEquals(1000.0, employee.net, 0.001)
    }

    @Test
    fun `tax is zero when wages greater than 1000 but exempt`() {
        val employee = Employee(name = "Test", wages = 2000.0, exempt = true)
        assertEquals(0.0, employee.taxes, 0.001)
        assertEquals(2000.0, employee.net, 0.001)
    }

    @Test
    fun `tax is zero when wages less than 1000`() {
        val employee = Employee(name = "Test", wages = 500.0, exempt = false)
        assertEquals(0.0, employee.taxes, 0.001)
        assertEquals(500.0, employee.net, 0.001)
    }
}