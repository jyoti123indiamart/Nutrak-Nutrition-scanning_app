package com.jyotisaxena.foodscannerapp.ui.theme

sealed class Screen(val route: String) {
    object Scan : Screen("scan")
    object Results : Screen("results")
    object Streaks : Screen("streaks")
}
