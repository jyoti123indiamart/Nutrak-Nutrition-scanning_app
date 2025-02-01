package com.jyotisaxena.foodscannerapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*

val PrimaryOrange = Color(0xFFFFA726) // Fire Orange for Streaks
val SecondaryGrey = Color(0xFFF1F1F1) // Light Grey Background
val ActiveGreen = Color(0xFF66BB6A) // Green for Active Days
val InactiveGrey = Color(0xFFBDBDBD) // Grey for Inactive Days

@Composable
fun StreaksScreen(navController: NavController?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 🔙 Back Button
        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { navController?.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 🔥 Fire Streak Badge with Number
        StreakBadge(streakCount = 5)

        Spacer(modifier = Modifier.height(10.dp))

        // 📝 Motivational Text
        Text(
            text = "You're on a 5-day streak!",
            style = MaterialTheme.typography.headlineMedium,
            color = PrimaryOrange
        )
        Text(
            text = "Keep it up!",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 📆 Streak Calendar (Aligned Horizontally for Days & Dates)
        StreakCalendar(streakDays = listOf(true, true, true, true, true, false, false), startDate = 30)

        Spacer(modifier = Modifier.height(20.dp))

        // 🎖️ Achievement Badge
        AchievementBadge(text = "10-day streak achiever")
    }
}

// 🔥 Streak Fire Animation with Number Overlay
@Composable
fun StreakBadge(streakCount: Int) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.streak_badge))

    Box(contentAlignment = Alignment.Center) {
        LottieAnimation(
            composition = composition,
            modifier = Modifier.size(120.dp)
        )
        Text(
            text = streakCount.toString(),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

// 📆 Streak Calendar (Aligned Correctly with Month Start from 30)
@Composable
fun StreakCalendar(streakDays: List<Boolean>, startDate: Int) {
    val days = listOf("M", "T", "W", "T", "F", "S", "S")
    val totalDaysInMonth = 30  // Assume current month has 30 days
    val previousMonthDays = listOf(30, 31) // Last two days of previous month
    val nextMonthDays = (1..totalDaysInMonth).toList() // Next month's dates

    // Combine previous & next month dates
    val allDates = previousMonthDays + nextMonthDays

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // 🔹 Row for Days of the Week
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            days.forEach { day ->
                Text(
                    text = day,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 🔥 Grid of Month Dates with Fire Icons for Active Streaks
        val numberOfWeeks = (allDates.size / 7) + 1
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            for (week in 0 until numberOfWeeks) {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    for (dayIndex in 0 until 7) {
                        val dateIndex = week * 7 + dayIndex
                        if (dateIndex >= allDates.size) break

                        val date = allDates[dateIndex]
                        val isActive = (dateIndex < streakDays.size) && streakDays[dateIndex]

                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .background(if (isActive) ActiveGreen else InactiveGrey, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isActive) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_fire),
                                    contentDescription = "Streak Day",
                                    tint = Color.White
                                )
                            } else {
                                Text(
                                    text = date.toString(),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// 🎖️ Achievement Badge
@Composable
fun AchievementBadge(text: String) {
    Surface(
        color = PrimaryOrange.copy(alpha = 0.2f),
        shape = CircleShape,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = PrimaryOrange,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
        )
    }
}

@Preview
@Composable
fun PreviewStreaksScreen() {
    StreaksScreen(navController = null)
}




/*package com.jyotisaxena.foodscannerapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

val PrimaryOrange = Color(0xFFFFA726) // Orange - energetic and food-related
val SecondaryGrey = Color(0xFFF1F1F1) // Light Grey - background neutrality
val AccentGreen = Color(0xFF66BB6A) // Green - health and success emphasis


@Composable
fun StreaksScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SecondaryGrey)
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
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
            Text(
                text = "You're on a 5-day streak! Keep it up!",
                style = MaterialTheme.typography.headlineMedium,
                color = PrimaryOrange
            )

            Spacer(modifier = Modifier.height(16.dp))

            StreakTracker(streakDays = listOf(true, true, true, true, true, false, false))

            Spacer(modifier = Modifier.height(16.dp))

            StreakBadgeAnimation()
        }

    }
}



*//*fun StreaksScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(5.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Back Button
        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text("You're on a 5-day streak! Keep it up!", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(10.dp))

        StreakTracker(streakDays = listOf(true, true, true, true, true, false, false))

        Spacer(modifier = Modifier.height(10.dp))

        StreakBadgeAnimation()
    }
}*//*

@Composable
fun StreakTracker(streakDays: List<Boolean>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        streakDays.forEach { isActive ->
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(if (isActive) AccentGreen else Color.Gray, shape = CircleShape)
            )
        }
    }
}


@Composable
fun StreakBadgeAnimation() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.streak_badge))

    LottieAnimation(
        composition = composition,
        modifier = Modifier.size(150.dp)
    )
}*/


