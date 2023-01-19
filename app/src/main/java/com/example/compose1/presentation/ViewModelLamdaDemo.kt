package com.example.compose1.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.wear.compose.material.*

data class DemoClass(
    val id: String,
    val name: String,
)

@Stable
class DemoViewModel : ViewModel() {

    private var index = 11

    val list = (1..10).toList().map  { index -> DemoClass(
        id = index.toString(),
        name = "Button $index"
        )
    }.toMutableStateList()

    fun doingSomething() {
        list.add(DemoClass(index.toString(), "Button $index"))
        index++
    }
}

@Composable
fun ViewModelLambdaDemo(
    listState: ScalingLazyListState,
    viewModel: DemoViewModel,
    modifier: Modifier = Modifier,
) {
    val list = viewModel.list

    ScalingLazyColumn(
        modifier = modifier,
        state = listState,
    ) {

        items(list, key = { item -> item.id}) {
            Button(
                onClick =
                { viewModel.doingSomething() },
                modifier = modifier,
                //viewModel::doingSomething
            ) {
                TextDemo(text = it.name)
                // Text(text = it.name)
            }
        }
    }
}

@Composable
fun TextDemo(text: String) {
    Text(text)
}