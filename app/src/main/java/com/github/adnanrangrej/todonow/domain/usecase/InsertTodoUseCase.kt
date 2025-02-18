package com.github.adnanrangrej.todonow.domain.usecase

import com.github.adnanrangrej.todonow.domain.model.Todo
import com.github.adnanrangrej.todonow.domain.repository.TodoRepository
import javax.inject.Inject

class InsertTodoUseCase @Inject constructor(private val repository: TodoRepository) {
    suspend operator fun invoke(todo: Todo) = repository.insertTodo(todo)
}