package com.example.cloudswithtile.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.rotary.onRotaryScrollEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import com.example.cloudswithtile.R
import kotlinx.coroutines.launch
import kotlin.math.abs

@Composable
fun Cat1Img1(mood1: String, navController: NavController,modifier: Modifier=Modifier) {
    val image = painterResource(R.drawable.cat1)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .absoluteOffset(0.dp, (-10).dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(150.dp)
                .padding(0.dp)
        )
        Text(text = mood1, fontSize = 12.sp, fontFamily = cloudsfont2, letterSpacing = 0.5.sp, modifier= Modifier.absoluteOffset(0.dp, (-25).dp))
        Spacer(Modifier.height(10.dp))
    }
}

@Composable
fun Cat1Img2(mood1: String, navController: NavController,modifier: Modifier=Modifier) {
    val image = painterResource(R.drawable.cat2)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(150.dp)
                .padding(0.dp)
        )
        Text(text = mood1, fontSize = 12.sp, fontFamily = cloudsfont2, letterSpacing = 0.5.sp, textAlign = TextAlign.Center, modifier= Modifier.absoluteOffset(0.dp, (-25).dp) .width(150.dp))
        Spacer(Modifier.height(10.dp))
    }
}

@Composable
fun Cat1Img3(mood1: String, navController: NavController,modifier: Modifier=Modifier) {
    val image = painterResource(R.drawable.cat3)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(150.dp)
                .padding(0.dp)
        )
        Text(text = mood1, fontSize = 12.sp, fontFamily = cloudsfont2, letterSpacing = 0.5.sp, modifier= Modifier.absoluteOffset(0.dp, (-25).dp))
        Spacer(Modifier.height(10.dp))
    }
}

@Composable
fun Cat1Img4(mood1: String, navController: NavController,modifier: Modifier=Modifier) {
    val image = painterResource(R.drawable.cat4)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(150.dp)
                .padding(0.dp)
        )
        Text(text = mood1, fontSize = 12.sp, fontFamily = cloudsfont2, letterSpacing = 0.5.sp, modifier= Modifier.absoluteOffset(0.dp, (-25).dp))
        Spacer(Modifier.height(10.dp))
    }
}

@Composable
fun Cat1Img5(mood1: String, navController: NavController,modifier: Modifier=Modifier) {
    val image = painterResource(R.drawable.cat5)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(150.dp)
                .padding(0.dp)
        )
        Text(text = mood1, fontSize = 12.sp, fontFamily = cloudsfont2, letterSpacing = 0.5.sp, modifier= Modifier.absoluteOffset(0.dp, (-25).dp))
        Spacer(Modifier.height(10.dp))
    }
}

@Composable
fun Cat1Img6(mood1: String, navController: NavController,modifier: Modifier=Modifier) {
    val image = painterResource(R.drawable.cat6)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(150.dp)
                .padding(0.dp)
        )
        Text(text = mood1, fontSize = 12.sp, fontFamily = cloudsfont2, letterSpacing = 0.5.sp, modifier= Modifier.absoluteOffset(0.dp, (-25).dp))
        Spacer(Modifier.height(10.dp))
    }
}

@Composable
fun Cat1Img7(mood1: String, navController: NavController,modifier: Modifier=Modifier) {
    val image = painterResource(R.drawable.cat7)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(150.dp)
                .padding(0.dp)
        )
        Text(text = mood1, fontSize = 12.sp, fontFamily = cloudsfont2, letterSpacing = 0.5.sp, modifier= Modifier.absoluteOffset(0.dp, (-25).dp))
        Spacer(Modifier.height(10.dp))
    }
}

@Composable
fun Cat1Img8(mood1: String, navController: NavController,modifier: Modifier=Modifier) {
    val image = painterResource(R.drawable.cat8)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(150.dp)
                .padding(0.dp)
        )
        Text(text = mood1, fontSize = 12.sp, fontFamily = cloudsfont2, letterSpacing = 0.5.sp, modifier= Modifier.absoluteOffset(0.dp, (-25).dp))
        Spacer(Modifier.height(10.dp))
    }
}

@Composable
fun Cat1Img9(mood1: String, navController: NavController,modifier: Modifier=Modifier) {
    val image = painterResource(R.drawable.cat9)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(150.dp)
                .padding(0.dp)
        )
        Text(text = mood1, fontSize = 12.sp, fontFamily = cloudsfont2, letterSpacing = 0.5.sp, modifier= Modifier.absoluteOffset(0.dp, (-25).dp))
        Spacer(Modifier.height(10.dp))
    }
}

@Composable
fun Cat1Img10(mood1: String, navController: NavController,modifier: Modifier=Modifier) {
    val image = painterResource(R.drawable.cat10)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(150.dp)
                .padding(0.dp)
        )
        Text(text = mood1, fontSize = 12.sp, fontFamily = cloudsfont2, letterSpacing = 0.5.sp, modifier= Modifier.absoluteOffset(0.dp, (-25).dp))
        Spacer(Modifier.height(17.dp))
    }
}




@Composable
fun Cat2Img1(navController: NavController) {
    val listState = rememberScalingLazyListState()
    val INT_KEY = "cat2mood"
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        val focusRequester = remember {
            FocusRequester()
        }
        val coroutineScope = rememberCoroutineScope()
        ScalingLazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding()
                .onRotaryScrollEvent { coroutineScope.launch { listState.scrollBy(it.verticalScrollPixels* abs(it.verticalScrollPixels)) };true }
                .focusRequester(focusRequester)
                .focusable()
                .fillMaxSize(),
            scalingParams = ScalingLazyColumnDefaults.scalingParams(),
            verticalArrangement = Arrangement.spacedBy(space = 0.dp),
            state = listState,
        )
        {
            items(6) { i ->
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
                if (i == 0) {
                    Spacer(Modifier.height(20.dp))
                } else if (i == 1) {
                    Cat1Img1(mood1 = "anger", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry11") })
                } else if (i == 2) {
                    Cat1Img1(mood1 = "annoyance", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry11") })
                } else if (i == 3) {
                    Cat1Img1(mood1 = "contempt", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry11") })
                } else if (i == 4) {
                    Cat1Img1(mood1 = "disgust", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry11") })
                } else if (i == 5) {
                    Cat1Img1(mood1 = "irritation", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry11") })
                }
            }
        }
    }
}

@Composable
fun Cat2Img2(navController: NavController) {
    val listState = rememberScalingLazyListState()
    val INT_KEY = "cat2mood"
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        val focusRequester = remember {
            FocusRequester()
        }
        val coroutineScope = rememberCoroutineScope()
        ScalingLazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding()
                .onRotaryScrollEvent { coroutineScope.launch { listState.scrollBy(it.verticalScrollPixels*abs(it.verticalScrollPixels)) };true }
                .focusRequester(focusRequester)
                .focusable()
                .fillMaxSize(),
            scalingParams = ScalingLazyColumnDefaults.scalingParams(),
            verticalArrangement = Arrangement.spacedBy(space = 0.dp),
            state = listState,
        )
        {
            items(7) { i ->
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
                if (i == 0) {
                    Spacer(Modifier.height(20.dp))
                } else if (i == 1) {
                    Cat1Img2(mood1 = "anxiety", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry22") })
                } else if (i == 2) {
                    Cat1Img2(mood1 = "embarrassment", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry22") })
                } else if (i == 3) {
                    Cat1Img2(mood1 = "fear", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry22") })
                } else if (i == 4) {
                    Cat1Img2(mood1 = "helpless", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry22") })
                } else if (i == 5) {
                    Cat1Img2(mood1 = "powerless", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry22") })
                } else if (i == 6) {
                    Cat1Img2(mood1 = "worry", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry22") })
                }
            }
        }
    }
}

@Composable
fun Cat2Img3(navController: NavController) {
    val listState = rememberScalingLazyListState()
    val INT_KEY = "cat2mood"
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        val focusRequester = remember {
            FocusRequester()
        }
        val coroutineScope = rememberCoroutineScope()
        ScalingLazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding()
                .onRotaryScrollEvent { coroutineScope.launch { listState.scrollBy(it.verticalScrollPixels*abs(it.verticalScrollPixels)) };true }
                .focusRequester(focusRequester)
                .focusable()
                .fillMaxSize(),
            scalingParams = ScalingLazyColumnDefaults.scalingParams(),
            verticalArrangement = Arrangement.spacedBy(space = 0.dp),
            state = listState,
        )
        {
            items(6) { i ->
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
                if (i == 0) {
                    Spacer(Modifier.height(20.dp))
                } else if (i == 1) {
                    Cat1Img3(mood1 = "doubt", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry33") })
                } else if (i == 2) {
                    Cat1Img3(mood1 = "envy", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry33") })
                } else if (i == 3) {
                    Cat1Img3(mood1 = "frustration", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry33") })
                } else if (i == 4) {
                    Cat1Img3(mood1 = "guilt", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry33") })
                } else if (i == 5) {
                    Cat1Img3(mood1 = "shame", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry33") })
                }
            }
        }
    }
}

@Composable
fun Cat2Img4(navController: NavController) {
    val listState = rememberScalingLazyListState()
    val INT_KEY = "cat2mood"
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        val focusRequester = remember {
            FocusRequester()
        }
        val coroutineScope = rememberCoroutineScope()
        ScalingLazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding()
                .onRotaryScrollEvent { coroutineScope.launch { listState.scrollBy(it.verticalScrollPixels*abs(it.verticalScrollPixels)) };true }
                .focusRequester(focusRequester)
                .focusable()
                .fillMaxSize(),
            scalingParams = ScalingLazyColumnDefaults.scalingParams(),
            verticalArrangement = Arrangement.spacedBy(space = 0.dp),
            state = listState,
        )
        {
            items(6) { i ->
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
                if (i == 0) {
                    Spacer(Modifier.height(20.dp))
                } else if (i == 1) {
                    Cat1Img4(mood1 = "boredom", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry44") })
                } else if (i == 2) {
                    Cat1Img4(mood1 = "despair", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry44") })
                } else if (i == 3) {
                    Cat1Img4(mood1 = "disappointment", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry44") })
                } else if (i == 4) {
                    Cat1Img4(mood1 = "hurt", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry44") })
                } else if (i == 5) {
                    Cat1Img4(mood1 = "sadness", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry44") })
                }
            }
        }
    }
}

@Composable
fun Cat2Img5(navController: NavController) {
    val listState = rememberScalingLazyListState()
    val INT_KEY = "cat2mood"
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        val focusRequester = remember {
            FocusRequester()
        }
        val coroutineScope = rememberCoroutineScope()
        ScalingLazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding()
                .onRotaryScrollEvent { coroutineScope.launch { listState.scrollBy(it.verticalScrollPixels*abs(it.verticalScrollPixels)) };true }
                .focusRequester(focusRequester)
                .focusable()
                .fillMaxSize(),
            scalingParams = ScalingLazyColumnDefaults.scalingParams(),
            verticalArrangement = Arrangement.spacedBy(space = 0.dp),
            state = listState,
        )
        {
            items(4) { i ->
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
                if (i == 0) {
                    Spacer(Modifier.height(20.dp))
                } else if (i == 1) {
                    Cat1Img5(mood1 = "shock", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry55") })
                } else if (i == 2) {
                    Cat1Img5(mood1 = "stress", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry55") })
                } else if (i == 3) {
                    Cat1Img5(mood1 = "tension", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry55") })
                }
            }
        }
    }
}

@Composable
fun Cat2Img6(navController: NavController) {
    val listState = rememberScalingLazyListState()
    val INT_KEY = "cat2mood"
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        val focusRequester = remember {
            FocusRequester()
        }
        val coroutineScope = rememberCoroutineScope()
        ScalingLazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding()
                .onRotaryScrollEvent { coroutineScope.launch { listState.scrollBy(it.verticalScrollPixels*abs(it.verticalScrollPixels)) };true }
                .focusRequester(focusRequester)
                .focusable()
                .fillMaxSize(),
            scalingParams = ScalingLazyColumnDefaults.scalingParams(),
            verticalArrangement = Arrangement.spacedBy(space = 0.dp),
            state = listState,
        )
        {
            items(7) { i ->
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
                if (i == 0) {
                    Spacer(Modifier.height(20.dp))
                } else if (i == 1) {
                    Cat1Img6(mood1 = "amusement", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry66") })
                } else if (i == 2) {
                    Cat1Img6(mood1 = "delight", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry66") })
                } else if (i == 3) {
                    Cat1Img6(mood1 = "excitement", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry66") })
                } else if (i == 4) {
                    Cat1Img6(mood1 = "happiness", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry66") })
                } else if (i == 5) {
                    Cat1Img6(mood1 = "joy", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry66") })
                } else if (i == 6) {
                    Cat1Img6(mood1 = "pleasure", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry66") })
                }
            }
        }
    }
}

@Composable
fun Cat2Img7(navController: NavController) {
    val listState = rememberScalingLazyListState()
    val INT_KEY = "cat2mood"
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        val focusRequester = remember {
            FocusRequester()
        }
        val coroutineScope = rememberCoroutineScope()
        ScalingLazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding()
                .onRotaryScrollEvent { coroutineScope.launch { listState.scrollBy(it.verticalScrollPixels*abs(it.verticalScrollPixels)) };true }
                .focusRequester(focusRequester)
                .focusable()
                .fillMaxSize(),
            scalingParams = ScalingLazyColumnDefaults.scalingParams(),
            verticalArrangement = Arrangement.spacedBy(space = 0.dp),
            state = listState,
        )
        {
            items(5) { i ->
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
                if (i == 0) {
                    Spacer(Modifier.height(20.dp))
                } else if (i == 1) {
                    Cat1Img7(mood1 = "affection", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry77") })
                } else if (i == 2) {
                    Cat1Img7(mood1 = "empathy", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry77") })
                } else if (i == 3) {
                    Cat1Img7(mood1 = "friendliness", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry77") })
                } else if (i == 4) {
                    Cat1Img7(mood1 = "love", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry77") })
                }
            }
        }
    }
}

@Composable
fun Cat2Img8(navController: NavController) {
    val listState = rememberScalingLazyListState()
    val INT_KEY = "cat2mood"
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        val focusRequester = remember {
            FocusRequester()
        }
        val coroutineScope = rememberCoroutineScope()
        ScalingLazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding()
                .onRotaryScrollEvent { coroutineScope.launch { listState.scrollBy(it.verticalScrollPixels*abs(it.verticalScrollPixels)) };true }
                .focusRequester(focusRequester)
                .focusable()
                .fillMaxSize(),
            scalingParams = ScalingLazyColumnDefaults.scalingParams(),
            verticalArrangement = Arrangement.spacedBy(space = 0.dp),
            state = listState,
        )
        {
            items(6) { i ->
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
                if (i == 0) {
                    Spacer(Modifier.height(20.dp))
                } else if (i == 1) {
                    Cat1Img8(mood1 = "courage", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry88") })
                } else if (i == 2) {
                    Cat1Img8(mood1 = "hope", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry88") })
                } else if (i == 3) {
                    Cat1Img8(mood1 = "pride", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry88") })
                } else if (i == 4) {
                    Cat1Img8(mood1 = "satisfaction", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry88") })
                } else if (i == 5) {
                    Cat1Img8(mood1 = "trust", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry88") })
                }
            }
        }
    }
}

@Composable
fun Cat2Img9(navController: NavController) {
    val listState = rememberScalingLazyListState()
    val INT_KEY = "cat2mood"
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        val focusRequester = remember {
            FocusRequester()
        }
        val coroutineScope = rememberCoroutineScope()
        ScalingLazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding()
                .onRotaryScrollEvent { coroutineScope.launch { listState.scrollBy(it.verticalScrollPixels*abs(it.verticalScrollPixels)) };true }
                .focusRequester(focusRequester)
                .focusable()
                .fillMaxSize(),
            scalingParams = ScalingLazyColumnDefaults.scalingParams(),
            verticalArrangement = Arrangement.spacedBy(space = 0.dp),
            state = listState,
        )
        {
            items(6) { i ->
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
                if (i == 0) {
                    Spacer(Modifier.height(20.dp))
                } else if (i == 1) {
                    Cat1Img9(mood1 = "calm", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry99") })
                } else if (i == 2) {
                    Cat1Img9(mood1 = "content", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry99") })
                } else if (i == 3) {
                    Cat1Img9(mood1 = "relaxed", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry99") })
                } else if (i == 4) {
                    Cat1Img9(mood1 = "relieved", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry99") })
                } else if (i == 5) {
                    Cat1Img9(mood1 = "serene", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry99") })
                }
            }
        }
    }
}

@Composable
fun Cat2Img10(navController: NavController) {
    val listState = rememberScalingLazyListState()
    val INT_KEY = "cat2mood"
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Scaffold(positionIndicator = { PositionIndicator(scalingLazyListState = listState) }) {
        val focusRequester = remember {
            FocusRequester()
        }
        val coroutineScope = rememberCoroutineScope()
        ScalingLazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding()
                .onRotaryScrollEvent { coroutineScope.launch { listState.scrollBy(it.verticalScrollPixels*abs(it.verticalScrollPixels)) };true }
                .focusRequester(focusRequester)
                .focusable()
                .fillMaxSize(),
            scalingParams = ScalingLazyColumnDefaults.scalingParams(),
            verticalArrangement = Arrangement.spacedBy(space = 0.dp),
            state = listState,
        )
        {
            items(4) { i ->
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
                if (i == 0) {
                    Spacer(Modifier.height(20.dp))
                } else if (i == 1) {
                    Cat1Img10(mood1 = "interest", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry1010") })
                } else if (i == 2) {
                    Cat1Img10(mood1 = "politeness", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry1010") })
                } else if (i == 3) {
                    Cat1Img10(mood1 = "surprise", navController = navController, modifier = Modifier.clickable { scope.launch{saveInt(context,i,INT_KEY)};navController.navigate("finalentry1010") })
                }
            }
        }
    }
}
