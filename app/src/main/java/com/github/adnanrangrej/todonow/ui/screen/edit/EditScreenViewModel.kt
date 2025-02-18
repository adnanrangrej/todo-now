package com.github.adnanrangrej.todonow.ui.screen.edit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.adnanrangrej.todonow.domain.usecase.DeleteTodoUseCase
import com.github.adnanrangrej.todonow.domain.usecase.GetTodoUseCase
import com.github.adnanrangrej.todonow.domain.usecase.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditScreenViewModel @Inject constructor(
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val getTodoUseCase: GetTodoUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _editUiState = MutableStateFlow(EditUiState())
    val editUiState: StateFlow<EditUiState> get() = _editUiState

    private val todoId: Int = checkNotNull(savedStateHandle["id"])

    init {
        viewModelScope.launch {
            _editUiState.value = getTodoUseCase(todoId)
                .filterNotNull()
                .first()
                .toEditUiState(true)
        }
    }

    private fun validateInput(uiState: TodoItem = editUiState.value.todoItem): Boolean {
        return with(uiState) {
            title.isNotBlank() && description.isNotBlank() && priority != null
        }
    }

    fun updateTodo() {
        viewModelScope.launch {
            if (validateInput()) {
                updateTodoUseCase(editUiState.value.todoItem.toTodo())
            }
        }
    }

    fun updateUiState(todoItem: TodoItem) {
        _editUiState.update { currentState ->
            currentState.copy(
                todoItem = todoItem,
                isEntryValid = validateInput(todoItem)
            )
        }
    }

    fun deleteTodo() {
        viewModelScope.launch {
            deleteTodoUseCase(editUiState.value.todoItem.toTodo())
        }
    }

}