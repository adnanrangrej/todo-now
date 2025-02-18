package com.github.adnanrangrej.todonow.ui.screen.edit

data class EditUiState(
    val todoItem: TodoItem = TodoItem(),
    val isEntryValid: Boolean = false
)