package com.github.adnanrangrej.todonow.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.adnanrangrej.todonow.R
import com.github.adnanrangrej.todonow.domain.model.Priority
import com.github.adnanrangrej.todonow.domain.model.Todo
import com.github.adnanrangrej.todonow.ui.theme.TodoNowTheme


@Composable
fun TodoItem(
    modifier: Modifier = Modifier,
    todo: Todo,
    onCompleteChange: (Boolean, Todo) -> Unit
) {

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = CardDefaults.shape
    ) {

        Row(modifier = Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text(
                    text = todo.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "some text",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(Modifier.weight(1f))

            CustomCheckBox(
                checked = todo.isCompleted,
                onCheckedChange = { isCompleted ->
                    onCompleteChange(isCompleted, todo)
                }
            )
        }
    }
}

@Composable
fun CustomCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    shape: Shape = RoundedCornerShape(50),
    size: Dp = 24.dp,
) {
    val borderColor =
        if (checked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant


    Box(
        modifier = modifier
            .size(size)
            .clip(shape = shape)
            .background(if (checked) MaterialTheme.colorScheme.primary else Color.Transparent)
            .clickable { onCheckedChange(!checked) }
            .border(2.dp, color = borderColor, shape = shape),
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = stringResource(R.string.checked),
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }


}

@Preview
@Composable
private fun TodoItemPreview() {
    TodoNowTheme {
        var isCompleted by remember { mutableStateOf(true) }
        TodoItem(
            todo = Todo(
                id = 1,
                title = "TodoNow",
                description = "Hello World",
                isCompleted = isCompleted,
                priority = Priority.LOW
            ),
            onCompleteChange = { bool, _ ->
                isCompleted = bool
            }
        )
    }
}