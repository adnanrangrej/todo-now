package com.github.adnanrangrej.todonow.ui.screen.add

import com.github.adnanrangrej.todonow.ui.screen.edit.TodoItem

data class AddUiState(
    val todoItem: TodoItem = TodoItem(),
    val isEntryValid: Boolean = false
)