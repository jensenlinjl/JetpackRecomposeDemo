package com.example.compose1.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text

@Composable
fun ModifierDemo(
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = text,
            modifier = modifier
        )

        Column(
            modifier = modifier.padding(start = 10.dp)
        ) {
            Text(
                text = text,
                modifier = modifier.padding(start = 10.dp)
            )
            Text(
                text = text,
                modifier = modifier.padding(start = 20.dp)
            )
        }
    }
}


@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun ModifierDemoPreview() {
    ModifierDemo(text = "Modifier Demo")
}