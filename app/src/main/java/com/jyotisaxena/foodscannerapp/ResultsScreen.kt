package com.jyotisaxena.foodscannerapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import androidx.compose.ui.viewinterop.AndroidView
import com.jyotisaxena.foodscannerapp.ui.theme.*

@Composable
fun ResultsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())  // Enables scrolling
            .padding(16.dp)
            .background(SecondaryGrey),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
            // Back Icon Button with custom icon
            IconButton(
                onClick = { navController.popBackStack() },
//            modifier = Modifier.padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(SecondaryGrey)
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Nutrition Breakdown",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    "Calories: 320 kcal",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
                )
                Text(
                    "Proteins: 20g, Carbs: 40g, Fats: 10g",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
                )
                Text(
                    "Vitamin A: 10%, Calcium: 15%",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                NutritionChart()

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { navController.navigate("streaks") },
                    colors = ButtonDefaults.buttonColors(containerColor = AccentGreen),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Save to Daily Log", color = Color.White, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { /* Upgrade logic */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFD700)), // Gold color for premium
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Upgrade to Premium", color = Color.Black, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(20.dp)) // Extra space at the bottom
            }
    }
}

@Composable
fun NutritionChart() {
    val entries = listOf(
        PieEntry(20f, "Proteins"),
        PieEntry(40f, "Carbs"),
        PieEntry(10f, "Fats")
    )

    val dataSet = PieDataSet(entries, "Macronutrients").apply {
        colors = listOf(
            ColorTemplate.MATERIAL_COLORS[0], // Red
            ColorTemplate.MATERIAL_COLORS[1], // Blue
            ColorTemplate.MATERIAL_COLORS[2]  // Green
        )
        valueTextSize = 16f // Larger text for readability
    }

    val data = PieData(dataSet)

    AndroidView(
        factory = { context ->
            PieChart(context).apply {
                setData(data)
                description.isEnabled = false
                legend.isEnabled = true
                setDrawEntryLabels(true)
                animateY(1000)
                invalidate()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(8.dp)
    )
}



/*
package com.jyotisaxena.foodscannerapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun ResultsScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Nutrition Breakdown", style = MaterialTheme.typography.headlineMedium)

        Text("Calories: 320 kcal")
        Text("Proteins: 20g, Carbs: 40g, Fats: 10g")
        Text("Vitamin A: 10%, Calcium: 15%")

        Spacer(modifier = Modifier.height(10.dp))

        NutritionChart()

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.navigate("streaks") }) {
            Text("Save to Daily Log")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { */
/* Upgrade logic *//*
 }, colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)) {
            Text("Upgrade to Premium")
        }
    }
}

@Composable
fun NutritionChart() {
    val entries = listOf(
        PieEntry(20f, "Proteins"),
        PieEntry(40f, "Carbs"),
        PieEntry(10f, "Fats")
    )
    val dataSet = PieDataSet(entries, "Macronutrients").apply {
        colors = ColorTemplate.COLORFUL_COLORS.toList()
    }
    val data = PieData(dataSet)

    AndroidView(factory = { context ->
        PieChart(context).apply {
            setData(data)
            description.isEnabled = false
            invalidate()
        }
    }, modifier = Modifier.fillMaxWidth().height(300.dp))
}
*/
