package com.github.adnanrangrej.todonow.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.adnanrangrej.todonow.domain.model.Todo
import com.github.adnanrangrej.todonow.ui.component.TodoItem

@Composable
fun TodoList(
    modifier: Modifier = Modifier,
    todoList: List<Todo>,
    contentPaddingValues: PaddingValues,
    onTodoClick: (Todo) -> Unit,
    onCompleteChange: (Boolean, Todo) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPaddingValues
    ) {
        items(items = todoList, key = { it.id }) { todo ->
            TodoItem(
                todo = todo,
                onCompleteChange = onCompleteChange,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onTodoClick(todo) }
            )
        }
    }
}