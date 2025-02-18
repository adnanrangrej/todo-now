package com.github.adnanrangrej.todonow.di

import android.content.Context
import androidx.room.Room
import com.github.adnanrangrej.todonow.data.local.AppDatabase
import com.github.adnanrangrej.todonow.data.local.dao.TodoDao
import com.github.adnanrangrej.todonow.data.repository.TodoRepositoryImp
import com.github.adnanrangrej.todonow.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context,AppDatabase::class.java,"todo_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(appDatabase: AppDatabase) : TodoDao {
        return appDatabase.todoDao()
    }

    @Provides
    @Singleton
    fun provideRepository(todoDao: TodoDao): TodoRepository{
        return TodoRepositoryImp(todoDao)
    }

}