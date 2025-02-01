package com.jyotisaxena.foodscannerapp

import com.jyotisaxena.foodscannerapp.ui.theme.FoodScannerAppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.jyotisaxena.foodscannerapp.ui.theme.AppNavHost


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodScannerAppTheme {
                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "scan") {
        composable("scan") { ScanScreen(navController) }
        composable("results") { ResultsScreen(navController) }
        composable("streaks") { StreaksScreen(navController) }
    }
}
