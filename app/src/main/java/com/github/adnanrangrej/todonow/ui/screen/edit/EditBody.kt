package com.github.adnanrangrej.todonow.ui.screen.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.github.adnanrangrej.todonow.R
import com.github.adnanrangrej.todonow.ui.component.InputForm
import com.github.adnanrangrej.todonow.ui.theme.TodoNowTheme

@Composable
fun EditBody(
    editUiState: EditUiState,
    modifier: Modifier = Modifier,
    onTodoValueChange: (TodoItem) -> Unit,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
    contentPaddingValues: PaddingValues = PaddingValues(0.dp)
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(contentPaddingValues),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        InputForm(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(8.dp),
            todoItem = editUiState.todoItem,
            onValueChange = onTodoValueChange
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Button(
                onClick = onEditClick,
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                enabled = editUiState.isEntryValid
            ) {
                Text(stringResource(R.string.edit_task))
            }

            Button(
                onClick = onDeleteClick,
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(stringResource(R.string.delete_task))
            }
        }
    }

}


@PreviewScreenSizes
@Composable
fun EditBodyPreview(modifier: Modifier = Modifier) {
    TodoNowTheme {
        EditBody(
            editUiState = EditUiState(),
            modifier = Modifier.fillMaxSize(),
            onTodoValueChange = {},
            onEditClick = {},
            onDeleteClick = {},
        )
    }
}