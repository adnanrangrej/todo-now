package com.github.adnanrangrej.todonow.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.adnanrangrej.todonow.ui.navigation.TodoNavHost

@Composable
fun TodoNowApp(navController: NavHostController = rememberNavController()) {
    TodoNavHost(navController)
}