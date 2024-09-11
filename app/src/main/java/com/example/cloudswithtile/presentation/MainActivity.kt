/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.cloudswithtile.presentation
import com.example.cloudswatch.presentation.theme.MoodAddedScreen
import android.content.Context
import androidx.compose.foundation.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.rotary.onRotaryScrollEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import com.example.cloudswithtile.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.math.abs

class MainActivity : ComponentActivity() {
    private val heartRateViewModel: HeartRateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            BackgroundIMG()
            HomeScreen()
            //HeartRateScreen(heartRateViewModel)
            //MoodBarGraph()
        }
        heartRateViewModel.startListening()

        // Stop listening when the activity is destroyed
        lifecycle.addObserver(LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_DESTROY) {
                heartRateViewModel.stopListening()
            }
        })

    }
}

val allanFamily = FontFamily(
    Font(R.font.allan, FontWeight.Normal)
)
val cloudsfont2 = FontFamily(
    Font(R.font.cloudsfont3, FontWeight.Normal)
)
val Context.dataStore by preferencesDataStore(name = "settings")

suspend fun saveInt(context: Context, value: Int, INT_KEY: String) {
    val KEY = intPreferencesKey(INT_KEY)
    context.dataStore.edit { preferences ->
        preferences[KEY] = value
    }
}

fun readInt(context: Context, INT_KEY: String): Flow<Int> {
    val KEY = intPreferencesKey(INT_KEY)
    return context.dataStore.data.map { preferences ->
        preferences[KEY] ?: 0
    }
}


@Composable
fun BackgroundIMG(): Unit {
    val image2 = painterResource(R.drawable.backgroundgrid)
    Image(
        painter = image2,
        contentDescription = null,
        modifier = Modifier
    )
}

@Composable
fun Cat1ImgList(navController: NavController) {
    val listState = rememberScalingLazyListState()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val num = 0
    val INT_KEY = "cat1mood"

    Scaffold (positionIndicator = { PositionIndicator(scalingLazyListState=listState)})
    {
        val focusRequester = remember {
            FocusRequester()
        }
        val coroutineScope = rememberCoroutineScope()
        ScalingLazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding()
                .onRotaryScrollEvent {
                    Log.d(
                        "speed",
                        (it.verticalScrollPixels * it.verticalScrollPixels * 0.5).toString()
                    )
                    coroutineScope.launch {
                        listState.scrollBy((it.verticalScrollPixels * abs(it.verticalScrollPixels) * 0.5).toFloat())
                    };true
                }
                .focusRequester(focusRequester)
                .focusable()
                .fillMaxSize(),
            scalingParams = ScalingLazyColumnDefaults.scalingParams(edgeScale = 0.5f, edgeAlpha = 0.02f),
            verticalArrangement = Arrangement.spacedBy(space=0.dp),
            state = listState,
        )
        {
            items(10) { i ->
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
                if (i==0) {
                    Column {
                        Spacer(modifier = Modifier.height(20.dp))
                        Cat1Img1(mood1 = "Negative and Forceful", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i+1,INT_KEY)};navController.navigate("cat2img1") })
                    }
                } else if (i==1) {
                    Cat1Img2(mood1 = "Negative and Uncontrollable", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i+1,INT_KEY)};navController.navigate("cat2img2") })
                } else if (i==2) {
                    Cat1Img3(mood1 = "Negative Thoughts", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i+1,INT_KEY)};navController.navigate("cat2img3") })
                }else if (i==3) {
                    Cat1Img4(mood1 = "Negative and Passive", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i+1,INT_KEY)};navController.navigate("cat2img4") })
                } else if (i==4) {
                    Cat1Img5(mood1 = "Agitation", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i+1,INT_KEY)};navController.navigate("cat2img5") })
                } else if (i==5) {
                    Cat1Img6(mood1 = "Positive and Lively", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i+1,INT_KEY)};navController.navigate("cat2img6") })
                } else if (i==6) {
                    Cat1Img7(mood1 = "Caring", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i+1,INT_KEY)};navController.navigate("cat2img7") })
                } else if (i==7) {
                    Cat1Img8(mood1 = "Positive Thoughts", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i+1,INT_KEY)};navController.navigate("cat2img8") })
                } else if (i==8) {
                    Cat1Img9(mood1 = "Quiet Positive", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i+1,INT_KEY)};navController.navigate("cat2img9") })
                } else {
                    Cat1Img10(mood1 = "Reactive", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i+1,INT_KEY)};navController.navigate("cat2img10") })
                    }
            }
        }
    }
}

@Composable
fun Wearapp(navController: NavController) {
    val image = painterResource(R.drawable.entermoodtext)

    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize())
    {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.height(25.dp)
        )
    }
        Box(contentAlignment = Center) {
            Cat1ImgList(navController = navController)
        }
}

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first_Screen") {
        composable("first_Screen") {
            Wearapp(navController = navController)
        }
        composable("cat2img1") {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Center) {
                Cat2Img1(navController = navController)
                BackButton(
                    navController = navController, modifier = Modifier
                        .width(140.dp)
                        .height(35.dp)
                )
            }
        }
        composable("cat2img2") {
            Cat2Img2(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("cat2img3") {
            Cat2Img3(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("cat2img4") {
            Cat2Img4(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("cat2img5") {
            Cat2Img5(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("cat2img6") {
            Cat2Img6(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("cat2img7") {
            Cat2Img7(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("cat2img8") {
            Cat2Img8(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("cat2img9") {
            Cat2Img9(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("cat2img10") {
            Cat2Img10(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("finalentry11") {
            FinalEntry11(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
    }
        composable("finalentry22") {
            FinalEntry22(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("finalentry33") {
            FinalEntry33(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("finalentry44") {
            FinalEntry44(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("finalentry55") {
            FinalEntry55(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("finalentry66") {
            FinalEntry66(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("finalentry77") {
            FinalEntry77(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("finalentry88") {
            FinalEntry88(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("finalentry99") {
            FinalEntry99(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("finalentry1010") {
            FinalEntry1010(navController = navController)
            BackButton(
                navController = navController, modifier = Modifier
                    .width(140.dp)
                    .height(35.dp)
            )
        }
        composable("moodaddedscreen") {
            MoodAddedScreen(navController = navController)
        }
        composable("statsscreen") {
            StatOne(modifier =Modifier, navController = navController)
        }
        composable("chatgptscreen") {
            ChatGptScreen(navController = navController)
            CloudsButton(navController = navController, modifier = Modifier
                .width(140.dp)
                .height(35.dp))
        }
    }
}




