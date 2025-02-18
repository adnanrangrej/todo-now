package com.github.adnanrangrej.todonow.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.adnanrangrej.todonow.R
import com.github.adnanrangrej.todonow.domain.model.Priority
import com.github.adnanrangrej.todonow.ui.screen.edit.TodoItem
import com.github.adnanrangrej.todonow.ui.theme.TodoNowTheme

@Composable
fun InputForm(
    modifier: Modifier = Modifier,
    todoItem: TodoItem,
    onValueChange: (TodoItem) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.schedule),
                style = MaterialTheme.typography.titleLarge
            )
        }

        item {
            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                value = todoItem.title,
                onValueChange = { onValueChange(todoItem.copy(title = it)) },
                placeholder = stringResource(R.string.enter_title),
                label = stringResource(R.string.title),
                isSingleLine = true,
                maxLine = 1
            )
        }

        item {
            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                value = todoItem.description,
                onValueChange = { onValueChange(todoItem.copy(description = it)) },
                placeholder = stringResource(R.string.enter_description),
                label = stringResource(R.string.description),
                isSingleLine = false,
                maxLine = 5
            )
        }

        item {
            Text(
                text = stringResource(R.string.priority),
                style = MaterialTheme.typography.bodyLarge
            )
        }

        item {
            PriorityRow(
                selectedPriority = todoItem.priority,
                onPrioritySelected = { onValueChange(todoItem.copy(priority = it)) }
            )
        }
    }

}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    label: String,
    isSingleLine: Boolean,
    maxLine: Int
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        label = { Text(label) },
        singleLine = isSingleLine,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        minLines = maxLine,
        maxLines = maxLine
    )
}

@Composable
fun PriorityRow(
    modifier: Modifier = Modifier,
    selectedPriority: Priority? = null,
    onPrioritySelected: (Priority) -> Unit
) {
    val priorities = Priority.entries.toTypedArray()

    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        priorities.forEach { priority ->
            OutlinedButton(
                onClick = { onPrioritySelected(priority) },
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (priority == selectedPriority) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                    contentColor = if (priority == selectedPriority) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(priority.name)
            }
        }

    }

}

@Preview
@Composable
private fun CustomTextFieldPreview() {
    var value by remember { mutableStateOf("") }
    TodoNowTheme {
        CustomTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value,
            onValueChange = { value = it },
            placeholder = stringResource(R.string.enter_description),
            label = stringResource(R.string.description),
            isSingleLine = false,
            maxLine = 5
        )
    }
}

@Preview
@Composable
private fun PriorityRowPreview() {
    TodoNowTheme {
        var selectedPriority by remember { mutableStateOf(Priority.LOW) }
        PriorityRow(
            selectedPriority = selectedPriority,
            onPrioritySelected = { newPriority ->
                selectedPriority = newPriority
            }
        )
    }
}

@Preview
@Composable
private fun InputFormPreview() {
    TodoNowTheme {
        InputForm(
            modifier = Modifier.fillMaxSize(),
            todoItem = TodoItem(),
            onValueChange = {}
        )
    }
}