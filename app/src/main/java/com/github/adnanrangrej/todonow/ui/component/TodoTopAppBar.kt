package com.github.adnanrangrej.todonow.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.github.adnanrangrej.todonow.R
import com.github.adnanrangrej.todonow.ui.theme.TodoNowTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    canNavigate: Boolean,
    navigateUp: () -> Unit = {}

) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigate) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        }

    )
}

@PreviewScreenSizes
@Composable
private fun TodoTopAppBarPreview() {
    TodoNowTheme {
        TodoTopAppBar(
            title = "TodoNow",
            canNavigate = true,
            navigateUp = {}
        )
    }
}