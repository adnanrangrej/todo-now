package com.github.adnanrangrej.todonow.ui.screen.add

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
fun AddScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    addScreenViewModel: AddScreenViewModel = hiltViewModel()
) {
    val uiState = addScreenViewModel.addUiState.collectAsState()

    Scaffold(
        topBar = {
            TodoTopAppBar(
                title = stringResource(R.string.app_name),
                canNavigate = true,
                navigateUp = onNavigateUp
            )
        }

    ) { innerPadding ->
        AddBody(
            modifier = Modifier.fillMaxSize(),
            addUiState = uiState.value,
            onSaveClick = {
                addScreenViewModel.addTodo()
                navigateBack()
            },
            onValueChange = { addScreenViewModel.updateUiState(it) },
            contentPaddingValues = innerPadding
        )

    }
}