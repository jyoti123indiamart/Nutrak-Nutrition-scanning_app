package com.jyotisaxena.foodscannerapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jyotisaxena.foodscannerapp.ResultsScreen
import com.jyotisaxena.foodscannerapp.ScanScreen
import com.jyotisaxena.foodscannerapp.StreaksScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Scan.route) {
        composable(Screen.Scan.route) { ScanScreen(navController) }
        composable(Screen.Results.route) { ResultsScreen(navController) }
        composable(Screen.Streaks.route) { StreaksScreen(navController) }
    }
}
