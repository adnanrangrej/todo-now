package com.github.adnanrangrej.todonow.ui.screen.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.adnanrangrej.todonow.R
import com.github.adnanrangrej.todonow.ui.component.TodoTopAppBar


@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
    navigateToEditScreen: (Int) -> Unit,
    navigateToAddScreen: () -> Unit
) {
    val homeUiState = homeScreenViewModel.homeUiState.collectAsState()
    val query = homeScreenViewModel.query.collectAsState()
    Scaffold(
        topBar = {
            TodoTopAppBar(
                title = stringResource(R.string.app_name),
                canNavigate = false,
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToAddScreen,
                modifier = Modifier.padding(20.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add)
                )
            }
        },
    ) { innerPadding ->

        HomeBody(
            modifier = Modifier.fillMaxSize(),
            todoList = homeUiState.value.todoList,
            contentPaddingValues = innerPadding,
            onTodoClick = navigateToEditScreen,
            onCompleteChange = { isCompleted, todo ->
                homeScreenViewModel.onCompletedChange(isCompleted, todo)
            },
            query = query.value,
            onQueryChange = { homeScreenViewModel.onQueryChange(it) }
        )

    }

}



