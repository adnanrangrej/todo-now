package com.github.adnanrangrej.todonow.ui.screen.edit

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.adnanrangrej.todonow.R
import com.github.adnanrangrej.todonow.ui.component.TodoTopAppBar

@Composable
fun EditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    editScreenViewModel: EditScreenViewModel = hiltViewModel()
) {
    val uiState = editScreenViewModel.editUiState.collectAsState()
    Scaffold(
        topBar = {
            TodoTopAppBar(
                title = stringResource(R.string.app_name),
                canNavigate = true,
                navigateUp = onNavigateUp
            )
        }
    ) { innerPadding ->
        EditBody(
            editUiState = uiState.value,
            modifier = Modifier.fillMaxSize(),
            onTodoValueChange = { editScreenViewModel.updateUiState(it) },
            onEditClick = {
                editScreenViewModel.updateTodo()
                navigateBack()
            },
            onDeleteClick = {
                editScreenViewModel.deleteTodo()
                navigateBack()
            },
            contentPaddingValues = innerPadding
        )
    }
}