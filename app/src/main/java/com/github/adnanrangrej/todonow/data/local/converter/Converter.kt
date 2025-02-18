package com.github.adnanrangrej.todonow.data.local.converter

import androidx.room.TypeConverter
import com.github.adnanrangrej.todonow.domain.model.Priority


class Converter {

    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(value: String): Priority {
        return when(value){
            Priority.LOW.name -> Priority.LOW
            Priority.MEDIUM.name -> Priority.MEDIUM
            Priority.HIGH.name -> Priority.HIGH
            else -> Priority.MEDIUM
        }
    }
}