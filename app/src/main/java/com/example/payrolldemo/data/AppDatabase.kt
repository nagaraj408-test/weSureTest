package com.example.payrolldemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.payrolldemo.data.local.dao.PayrollDao
import com.example.payrolldemo.data.local.entity.EmployeeEntity
import com.example.payrolldemo.data.local.entity.PayrollEntity

@Database(
    entities = [PayrollEntity::class, EmployeeEntity::class], version = 1
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun payrollDao(): PayrollDao

    companion object {
        fun create(
            context: Context
        ) = Room.databaseBuilder(
            context, AppDatabase::class.java, "payrolldata.db"
        ).build()
    }
}