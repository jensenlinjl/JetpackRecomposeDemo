package com.example.compose1.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*

val demoThreadList = mutableStateListOf(
    ThreadItem("1", "Subject1", "Jon"),
    ThreadItem("2", "Subject2", "Martin"),
    ThreadItem("3", "Subject3", "FunGuy"),
)

private val addEmail: () -> Unit = {
    val id = seedId++
    val threadItem = ThreadItem(id.toString(), "Subject$id", "Unknown$id")
    demoThreadList.add(0, threadItem)
}

@Composable
fun RecomposeDemo2(
    listState: ScalingLazyListState,
) {
    val threadList = demoThreadList
    ScalingLazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = listState
    ) {
        items(threadList, key = {
            item -> item.id
        }) { item ->
            ThreadItem2(threadItem =  item,
                addEmailLamda = addEmail,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp))
        }
    }
}

@Composable
fun ThreadItem2(threadItem: ThreadItem,
               addEmailLamda: () -> Unit,
               modifier: Modifier = Modifier, ) {

    Column(modifier = modifier) {
        Text(
            text = "From: ${threadItem.sender}",
            Modifier.clickable(onClick = addEmail)
        )
        Text(
            text = threadItem.subject
        )
    }
}