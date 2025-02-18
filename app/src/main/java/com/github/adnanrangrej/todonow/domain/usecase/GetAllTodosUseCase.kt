package com.github.adnanrangrej.todonow.domain.usecase

import com.github.adnanrangrej.todonow.domain.model.Todo
import com.github.adnanrangrej.todonow.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTodosUseCase @Inject constructor(private val repository: TodoRepository) {
    operator fun invoke(): Flow<List<Todo>> = repository.getAllTodo()
}