package com.example.cloudswithtile.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.rotary.onRotaryScrollEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import kotlin.math.abs
import androidx.wear.compose.material.ButtonColors
import androidx.wear.compose.material.ButtonDefaults
import com.example.cloudswithtile.R
import kotlinx.coroutines.delay

class ChatGptViewModel : ViewModel() {
    var responseText by mutableStateOf("")
    var gptQuery by mutableStateOf("")

    @OptIn(BetaOpenAI::class)
    fun getGPTResponse() {
        viewModelScope.launch {
            val openAI = OpenAI("insertkeyhere") // Replace with your actual API key

            try {
                val chatCompletionRequest = ChatCompletionRequest(
                    model = ModelId("gpt-4"),
                    messages = listOf(
                        ChatMessage(
                            role = ChatRole.Assistant,
                            content = gptQuery
                        )
                    )
                )
                val response = openAI.chatCompletion(chatCompletionRequest)
                responseText = response.choices.first().message?.content ?: "null"
            } catch (e: Exception) {
                responseText = "ERROR: ${e.message}"
            }
        }
    }
}


@Composable
fun ChatGptScreen(navController: NavHostController, viewModel: ChatGptViewModel = viewModel()) {
    val context = LocalContext.current

    val hour1 = readInt(context,"hour")
    val day1 = readInt(context,"day")
    val moodnum1 = readInt(context,"cat1mood")
    val moodnum21 = readInt(context,"cat2mood")
    val moodnumpc1 = readInt(context,"cat2perc")
    val moodhr = readInt(context,"hr")
    val hour2 = hour1.collectAsState(initial = 0).value
    val hour = hourConverter(hour2)
    val day = day1.collectAsState(initial = 0).value
    val moodnum = moodnum1.collectAsState(initial = 0).value
    val moodnum2 = moodnum21.collectAsState(initial = 0).value
    val moodnumpc = moodnumpc1.collectAsState(initial = 0).value
    val hr = moodhr.collectAsState(initial = 0).value
    val moodstring = numtomoodconverter(moodnum)
    val mood2string = numtomood2converter(moodnum,moodnum2)
    val image = painterResource(R.drawable.logo)
    val listState = rememberScalingLazyListState()
    Log.d("time" , hour.toString())
    var query = "i am feeling $moodnumpc % $moodstring, more specifically $mood2string, the time is $hour 00 (24 hour time), it's $day, my heart rate is $hr and i am currently near University. Use all this data to give me advice in less than 20 words. Acknowledge how I am feeling first. Tell me about the correlation between my mood and my percentage, heart rate, day, time or location as well. Talk to me in a cheerful, friendly and lighthearted tone."
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) })
    {
        val focusRequester = remember {
            FocusRequester()
        }
        val coroutineScope = rememberCoroutineScope()
        Box (contentAlignment = Alignment.TopCenter) {
            ScalingLazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp)
                    .onRotaryScrollEvent {
                        Log.d(
                            "speed",
                            (it.verticalScrollPixels * 2).toString()
                        )
                        coroutineScope.launch {
                            listState.scrollBy(it.verticalScrollPixels * 2)
                        };true
                    }
                    .focusRequester(focusRequester)
                    .focusable(),
                scalingParams = ScalingLazyColumnDefaults.scalingParams(),
                verticalArrangement = Arrangement.spacedBy(space=5.dp),
                state = listState,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(8) { i ->
                    LaunchedEffect(Unit) {
                        focusRequester.requestFocus()
                    }
                    when (i) {
                        1 -> {
                            Text(
                                "Smart Insights!",
                                fontSize = 20.sp,
                                fontFamily = cloudsfont2,
                                textAlign = TextAlign.Center,
                            )
                        }

                        3 -> {
                            //Row {
                            var alpha by remember {
                                mutableFloatStateOf(1f)
                            }
                            Text(
                                text = "try me! ->",
                                fontFamily = cloudsfont2,
                                fontSize = 8.sp,
                                modifier = Modifier.offset(0.dp, 23.dp)
                            )
                            Image(painter = image, contentDescription = null, modifier = Modifier
                                .height(90.dp)
                                .padding(25.dp)
                                .clickable {
                                    viewModel.gptQuery = query
                                    viewModel.getGPTResponse()
                                    alpha = 0f
                                    for (i in 0..19) {
                                        alpha += 0.05f
                                    }

                                })
                            //}
                        }

                        5 -> {
                            Text(
                                text = viewModel.responseText,
                                fontFamily = cloudsfont2,
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(5.dp)
                            )
                        }
                    }
                }
            }
        }
    }

}

fun hourConverter(hour:Int): String {
    var answer = hour.toString()
    if (hour.toString().length==1) {
        answer = "0"+hour.toString()
    }
    return answer
}