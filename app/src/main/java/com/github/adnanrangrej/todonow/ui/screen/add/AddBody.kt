package com.github.adnanrangrej.todonow.ui.screen.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.github.adnanrangrej.todonow.ui.screen.edit.TodoItem
import com.github.adnanrangrej.todonow.ui.theme.TodoNowTheme

@Composable
fun AddBody(
    modifier: Modifier = Modifier,
    addUiState: AddUiState,
    onSaveClick: () -> Unit,
    onValueChange: (TodoItem) -> Unit,
    contentPaddingValues: PaddingValues = PaddingValues(0.dp)
) {
    Column(
        modifier = modifier.padding(contentPaddingValues),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        InputForm(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(8.dp),
            todoItem = addUiState.todoItem,
            onValueChange = onValueChange
        )

        Button(
            onClick = onSaveClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            enabled = addUiState.isEntryValid
        ) {
            Text(stringResource(R.string.add_Task))
        }
    }
}

@PreviewScreenSizes
@Composable
private fun AddBodyPreview() {
    TodoNowTheme {
        AddBody(
            addUiState = AddUiState(),
            onSaveClick = {},
            onValueChange = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}