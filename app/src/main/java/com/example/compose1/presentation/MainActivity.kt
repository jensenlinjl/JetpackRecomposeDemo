package com.example.compose1.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import com.example.compose1.presentation.theme.Compose1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //DemoModifier()
            //DemoRecompose()
            DemoViewModelLambda()
        }
    }
}

@Composable
fun DemoModifier() {
    Compose1Theme {
        val listState = rememberScalingLazyListState()

        Scaffold(
            timeText = {
                TimeText(modifier = Modifier.scrollAway(listState))
            },
            vignette = {
                Vignette(vignettePosition = VignettePosition.TopAndBottom)
            },
            positionIndicator = {
                PositionIndicator(scalingLazyListState = listState)
            }
        ) {
            ScalingLazyColumn(
                modifier = Modifier.padding(top = 20.dp),
                state = listState
            ) {
                val itemModifier = Modifier.fillMaxWidth()
                val itemModifier2 = Modifier.width(180.dp)
                val itemModifier3 = Modifier
                    .fillMaxWidth()
                    .clickable { Log.d("ModifierDemo", "DemoModifier clicked.") }
                    .padding(start = 30.dp)


                items(10) {
                    ModifierDemo(
                        "Demo Modifier $it",
                        modifier = itemModifier3
                    )
                }
            }

        }
    }
}

@Composable
fun DemoRecompose() {
    Compose1Theme {
        val listState = rememberScalingLazyListState()

        Scaffold(
            timeText = {
                TimeText(modifier = Modifier.scrollAway(listState))
            },
            vignette = {
                Vignette(vignettePosition = VignettePosition.TopAndBottom)
            },
            positionIndicator = {
                PositionIndicator(scalingLazyListState = listState)
            }
        ) {
            //RecomposeDemo1(listState)
             RecomposeDemo2(listState)
        }
    }
}

@Composable
fun DemoViewModelLambda() {
    Compose1Theme {
        val listState = rememberScalingLazyListState()

        Scaffold(
            timeText = {
                TimeText(modifier = Modifier.scrollAway(listState))
            },
            vignette = {
                Vignette(vignettePosition = VignettePosition.TopAndBottom)
            },
            positionIndicator = {
                PositionIndicator(scalingLazyListState = listState)
            }
        ) {
            val viewModel = remember {
                DemoViewModel()
            }

            ViewModelLambdaDemo(listState, viewModel,
                            modifier = Modifier.padding(2.dp))
        }
    }
}