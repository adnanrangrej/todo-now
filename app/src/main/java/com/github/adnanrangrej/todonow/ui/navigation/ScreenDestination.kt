package com.github.adnanrangrej.todonow.ui.navigation

sealed class ScreenDestination(val route: String) {
    object Home : ScreenDestination("home")
    data class Edit(val id: Int) : ScreenDestination("edit/$id")
    object Add : ScreenDestination("add")
}