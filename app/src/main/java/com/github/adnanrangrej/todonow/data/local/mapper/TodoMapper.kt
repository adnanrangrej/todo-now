package com.github.adnanrangrej.todonow.data.local.mapper

import com.github.adnanrangrej.todonow.data.local.entity.TodoEntity
import com.github.adnanrangrej.todonow.domain.model.Todo

    fun TodoEntity.toDomain(): Todo = Todo(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
        priority = priority,
    )

    fun Todo.toEntity(): TodoEntity = TodoEntity(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
        priority = priority,
    )
