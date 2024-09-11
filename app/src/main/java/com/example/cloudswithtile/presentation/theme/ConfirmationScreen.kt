package com.example.cloudswatch.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text
import com.example.cloudswithtile.presentation.HeartRateViewModel
import com.example.cloudswithtile.presentation.MintGreen
import com.example.cloudswithtile.presentation.cloudsfont2
import com.example.cloudswithtile.presentation.getCurrentTimeAndDate
import com.example.cloudswithtile.presentation.readInt
import com.example.cloudswithtile.presentation.saveInt
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MoodAddedScreen(modifier: Modifier = Modifier, navController: NavController) {
    var isVisible by remember { mutableStateOf(false) }
    val offsetY = remember { Animatable(0f) }
    val offsetX = remember { Animatable(70f) }
    isVisible = false
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedContent(
            isVisible = isVisible,
            offsetY = offsetY,
            offsetX = offsetX,
            navController = navController
        )
    }
}


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun AnimatedContent(isVisible: Boolean, offsetY: Animatable<Float, AnimationVector1D>, offsetX: Animatable<Float, AnimationVector1D>, navController: NavController,heartRateViewModel: HeartRateViewModel = viewModel()) {
    var ok by remember {
        mutableStateOf(false)
    }
    var isVis by remember { mutableStateOf(isVisible) }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val heartRate by heartRateViewModel.heartRate.observeAsState()

    val month = getCurrentTimeAndDate().substring(5,7)
    val hour = getCurrentTimeAndDate().substring(11,13)

    LaunchedEffect(isVis) {
        heartRateViewModel.startListening()
        if (isVis) {
            offsetX.animateTo(8f, animationSpec = tween(durationMillis = 1100))
        } else {
            // Animate to show
            offsetY.animateTo(-8f, animationSpec = tween(durationMillis = 800))
            delay(500)
            isVis = true
        }
        while (heartRate==null) {
            scope.launch { heartRate?.let { saveInt(context, it.toInt(),"hr") } }
            heartRateViewModel.updateHeartRate()
            kotlinx.coroutines.delay(200L)
        }
        while (heartRate!! <= 0.0f){
            heartRateViewModel.updateHeartRate()
            kotlinx.coroutines.delay(200L)
        }
        scope.launch { heartRate?.let { saveInt(context, it.toInt(),"hr") };
            saveInt(context, month.toInt(),"month");
            saveInt(context, hour.toInt(),"hour");
            ok = true}
    }
    val moodnumfr = readInt(context,"cat1mood")
    val moodnumf = readInt(context,"cat2mood")
    val moodnump = readInt(context,"cat2perc")
    val moodhr = readInt(context,"hr")
    val moodnum = moodnumfr.collectAsState(initial = 0).value
    val moodnum2 = moodnumf.collectAsState(initial = 0).value
    val moodnumpc = moodnump.collectAsState(initial = 0).value
    val hr = moodhr.collectAsState(initial = 0).value
    if (isVis) {

        Column(
            modifier = Modifier
                .padding(0.dp)
                .offset(0.dp, 26.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Fading in text
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Mood entered!",
                fontSize = 24.sp,
                color = Color.White,
                fontFamily = cloudsfont2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .alpha(1f)
                    .offset(y = offsetY.value.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { if (ok) {navController.navigate("chatgptscreen")} }, modifier = Modifier
                .alpha(1f)
                .offset(y = offsetX.value.dp - 10.dp)
                .height(60.dp)
                .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = MintGreen)) {
                Text(text = "lesgo", color = Color.DarkGray)
            }
        }
    } else {
        Column(
            modifier = Modifier
                .padding(0.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Fading in text
            Text(
                text = "Mood entered!",
                fontSize = 24.sp,
                color = Color.White,
                fontFamily = cloudsfont2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .alpha(1f)
                    .offset(y = offsetY.value.dp)
            )
        }
    }
}