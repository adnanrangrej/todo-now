package com.github.adnanrangrej.todonow.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.adnanrangrej.todonow.domain.model.Todo
import com.github.adnanrangrej.todonow.domain.usecase.GetAllTodosUseCase
import com.github.adnanrangrej.todonow.domain.usecase.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllTodosUseCase: GetAllTodosUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase
) : ViewModel() {
    private val _query = MutableStateFlow("")

    val query: StateFlow<String> get() = _query

    val homeUiState: StateFlow<HomeUiState> =
        getAllTodosUseCase().combine(_query) { todos, query ->
            val filteredTodos = if (query.isBlank()) {
                todos
            } else {
                todos.filter { todo ->
                    todo.title.contains(query, ignoreCase = true) ||
                            todo.description.contains(query, ignoreCase = true)
                }
            }
            HomeUiState(filteredTodos)
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    fun onCompletedChange(isCompleted: Boolean, todo: Todo) {
        viewModelScope.launch {
            val updatedTodo = todo.copy(isCompleted = isCompleted)
            updateTodoUseCase(updatedTodo)
        }
    }

    fun onQueryChange(query: String) {
        _query.update {
            query
        }
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}