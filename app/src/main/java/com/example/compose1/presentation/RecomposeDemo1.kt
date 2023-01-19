package com.example.compose1.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

@Stable
data class ThreadItem(
    val id: String,
    val subject: String,
    val sender: String,
    val senders: List<String> = listOf("a", "b"),
    // var subject,
)

var seedId = 4

val threadListModifier = Modifier
    .fillMaxWidth()
    .padding(start = 24.dp)

private val demoThreadListMutableStateFlow = MutableStateFlow(
    mutableListOf(
        ThreadItem("1", "Subject1", "Jon"),
        ThreadItem("2", "Subject2", "Martin"),
        ThreadItem("3", "Subject3", "FunGuy"),
    )
)

private val addEmail: () -> Unit = {
    val id = seedId++
    val threadItem = ThreadItem(id.toString(), "Subject$id", "Unknown$id")
    //val list = demoThreadListMutableStateFlow.value.toMutableList()
    demoThreadListMutableStateFlow.value.add(threadItem)

}


@Composable
fun RecomposeDemo1(
    listState: ScalingLazyListState,
) {
    val threadList by demoThreadListMutableStateFlow.collectAsState()
    ScalingLazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = listState
    ) {

        items(threadList, key = {
            item -> item.id
        }) { item ->
            ThreadItem1(threadItem =  item,
                addEmailLamda = addEmail,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp))
        }
    }
}

@Composable
fun ThreadItem1(threadItem: ThreadItem,
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