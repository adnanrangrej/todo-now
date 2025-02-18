package com.github.adnanrangrej.todonow.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.adnanrangrej.todonow.data.local.converter.Converter
import com.github.adnanrangrej.todonow.data.local.dao.TodoDao
import com.github.adnanrangrej.todonow.data.local.entity.TodoEntity

@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}