package com.github.adnanrangrej.todonow.domain.model

data class Todo(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val priority: Priority
)
