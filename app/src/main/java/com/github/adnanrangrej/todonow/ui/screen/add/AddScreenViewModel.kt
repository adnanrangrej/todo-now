package com.github.adnanrangrej.todonow.ui.screen.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.adnanrangrej.todonow.domain.usecase.InsertTodoUseCase
import com.github.adnanrangrej.todonow.ui.screen.edit.TodoItem
import com.github.adnanrangrej.todonow.ui.screen.edit.toTodo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddScreenViewModel @Inject constructor(
    private val insertTodoUseCase: InsertTodoUseCase
) : ViewModel() {

    private val _addUiState = MutableStateFlow(AddUiState())
    val addUiState: StateFlow<AddUiState> get() = _addUiState

    fun updateUiState(todoItem: TodoItem) {
        _addUiState.update { currentState ->
            currentState.copy(
                todoItem = todoItem,
                isEntryValid = validateInput(todoItem)
            )
        }
    }

    private fun validateInput(uiState: TodoItem = addUiState.value.todoItem): Boolean {
        return with(uiState) {
            title.isNotBlank() && description.isNotBlank() && priority != null
        }
    }

    fun addTodo() {
        if (validateInput()) {
            viewModelScope.launch {
                insertTodoUseCase(addUiState.value.todoItem.toTodo())
            }
        }
    }
}