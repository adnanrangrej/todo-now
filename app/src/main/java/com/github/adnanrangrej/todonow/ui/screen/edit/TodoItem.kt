package com.github.adnanrangrej.todonow.ui.screen.edit

import com.github.adnanrangrej.todonow.domain.model.Priority
import com.github.adnanrangrej.todonow.domain.model.Todo

data class TodoItem(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false,
    val priority: Priority? = null
)

fun TodoItem.toTodo(): Todo = Todo(
    id = id,
    title = title,
    description = description,
    isCompleted = isCompleted,
    priority = priority!!
)

fun Todo.toEditUiState(isEntryValid: Boolean): EditUiState = EditUiState(
    todoItem = this.toTodoItem(),
    isEntryValid = isEntryValid
)

fun Todo.toTodoItem(): TodoItem = TodoItem(
    id = id,
    title = title,
    description = description,
    isCompleted = isCompleted,
    priority = priority
)