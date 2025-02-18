package com.github.adnanrangrej.todonow.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.github.adnanrangrej.todonow.ui.screen.add.AddScreen
import com.github.adnanrangrej.todonow.ui.screen.edit.EditScreen
import com.github.adnanrangrej.todonow.ui.screen.home.HomeScreen

@Composable
fun TodoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = ScreenDestination.Home.route,
        modifier = modifier
    ) {

        composable(route = ScreenDestination.Home.route) {
            HomeScreen(
                navigateToEditScreen = { navController.navigate(ScreenDestination.Edit(it).route) },
                navigateToAddScreen = { navController.navigate(ScreenDestination.Add.route) }
            )
        }

        composable(route = "edit/{id}", arguments = listOf(
            navArgument(name = "id") {
                type = NavType.IntType
            }
        )) {
            EditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }

        composable(route = ScreenDestination.Add.route) {
            AddScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() },
            )
        }
    }

}