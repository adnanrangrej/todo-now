package com.github.adnanrangrej.todonow.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.github.adnanrangrej.todonow.data.local.entity.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todoEntity: TodoEntity)

    @Delete
    suspend fun delete(todoEntity: TodoEntity)

    @Update
    suspend fun update(todoEntity: TodoEntity)

    @Query("SELECT * FROM todo")
    fun getAllTodo() : Flow<List<TodoEntity>>

    @Query("SELECT * FROM todo WHERE id = :id")
    fun getTodo(id: Int) : Flow<TodoEntity>

}