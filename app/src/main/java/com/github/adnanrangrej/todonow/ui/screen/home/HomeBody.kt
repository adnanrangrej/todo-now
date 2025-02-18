package com.github.adnanrangrej.todonow.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.github.adnanrangrej.todonow.R
import com.github.adnanrangrej.todonow.domain.model.Todo
import com.github.adnanrangrej.todonow.ui.component.TodoSearchBar

@Composable
fun HomeBody(
    modifier: Modifier = Modifier,
    todoList: List<Todo>,
    contentPaddingValues: PaddingValues,
    onTodoClick: (Int) -> Unit,
    onCompleteChange: (Boolean, Todo) -> Unit,
    query: String,
    onQueryChange: (String) -> Unit,
) {
    Column(
        modifier = modifier.padding(contentPaddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TodoSearchBar(
            query = query,
            onQueryChange = onQueryChange,
            modifier = Modifier.fillMaxWidth()
        )
        if (todoList.isEmpty()) {
            Text(
                text = stringResource(R.string.no_todo_description),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(contentPaddingValues)
            )
        } else {
            TodoList(
                todoList = todoList,
                contentPaddingValues = PaddingValues(0.dp),
                onTodoClick = { onTodoClick(it.id) },
                onCompleteChange = onCompleteChange,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }

    }
}

@PreviewScreenSizes
@Composable
private fun HomeBodyPreview() {
    HomeBody(
        modifier = Modifier.fillMaxSize(),
        todoList = listOf(),
        contentPaddingValues = PaddingValues(0.dp),
        onTodoClick = {  },
        onCompleteChange = {_,_ ->},
        query = "",
        onQueryChange = {  }
    )
}