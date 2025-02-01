package com.jyotisaxena.foodscannerapp

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.delay
import com.jyotisaxena.foodscannerapp.ui.theme.*

@Composable
fun ScanScreen(navController: NavController) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var isScanning by remember { mutableStateOf(false) }

    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        imageUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(SecondaryGrey),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Ensure your food is well-lit and in focus for the most accurate scan.",
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        imageUri?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = "Selected Image",
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.White, RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { galleryLauncher.launch("image/*") },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryOrange),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Select from Gallery", color = Color.White, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { isScanning = true },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryOrange),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Start Scanning", color = Color.White, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isScanning) {
            ScanProgressIndicator { navController.navigate("results") }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Navigate to StreaksScreen
        Button(
            onClick = { navController.navigate("streaks") },
            colors = ButtonDefaults.buttonColors(containerColor = AccentGreen),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View Streaks", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ScanProgressIndicator(onComplete: () -> Unit) {
    var progress by remember { mutableStateOf(0f) }
    val infiniteTransition = rememberInfiniteTransition()

    val animatedProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    LaunchedEffect(Unit) {
        delay(2500) // Simulate scan time
        onComplete()
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        LinearProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier.fillMaxWidth(),
            color = PrimaryOrange
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Scanning...",
            color = Color.Gray,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}




/*
package com.jyotisaxena.foodscannerapp

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.delay

@Composable
fun ScanScreen(navController: NavController) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var isScanning by remember { mutableStateOf(false) }

    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        imageUri = uri
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Ensure your food is well-lit and in focus for the most accurate scan.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        imageUri?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = "Selected Image",
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { galleryLauncher.launch("image/*") }) {
            Text("Select from Gallery")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            isScanning = true
        }) {
            Text("Start Scanning")
        }

        if (isScanning) {
            ScanProgressIndicator { navController.navigate("results") }
        }
    }
}

@Composable
fun ScanProgressIndicator(onComplete: () -> Unit) {
    var progress by remember { mutableStateOf(0f) }

    LaunchedEffect(Unit) {
        while (progress < 1f) {
            delay(500)
            progress += 0.25f
        }
        onComplete()
    }

    LinearProgressIndicator(progress = progress, modifier = Modifier.fillMaxWidth())
}
*/