package com.github.adnanrangrej.todonow.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.adnanrangrej.todonow.domain.model.Priority

@Entity(tableName = "todo")
data class TodoEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo("title")
    val title: String,

    @ColumnInfo("description")
    val description: String,

    @ColumnInfo("is_completed")
    val isCompleted: Boolean,

    @ColumnInfo("priority")
    val priority: Priority
)
