package com.github.adnanrangrej.todonow.data.repository

import com.github.adnanrangrej.todonow.data.local.dao.TodoDao
import com.github.adnanrangrej.todonow.data.local.mapper.toDomain
import com.github.adnanrangrej.todonow.data.local.mapper.toEntity
import com.github.adnanrangrej.todonow.domain.model.Todo
import com.github.adnanrangrej.todonow.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImp @Inject constructor(private val dao: TodoDao) : TodoRepository {
    override suspend fun insertTodo(todo: Todo) {
        dao.insert(todo.toEntity())
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.delete(todo.toEntity())
    }

    override suspend fun updateTodo(todo: Todo) {
        dao.update(todo.toEntity())
    }

    override fun getAllTodo(): Flow<List<Todo>> {
        return dao.getAllTodo().map { todoEntityList ->
            todoEntityList.map { todoEntity ->
                todoEntity.toDomain()
            }
        }
    }

    override fun getTodo(id: Int): Flow<Todo> {
        return dao.getTodo(id).map { it.toDomain() }
    }
}