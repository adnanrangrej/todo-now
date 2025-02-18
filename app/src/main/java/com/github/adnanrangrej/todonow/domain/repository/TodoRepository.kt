package com.github.adnanrangrej.todonow.domain.repository

import com.github.adnanrangrej.todonow.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun insertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)

    suspend fun updateTodo(todo: Todo)

    fun getAllTodo() : Flow<List<Todo>>

    fun getTodo(id: Int) : Flow<Todo>
}