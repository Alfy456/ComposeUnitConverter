package com.example.unitconverter.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.unitconverter.data.ConversionResult

@Composable
fun HistoryList(
    list: State<List<ConversionResult>>,
    onCloseTask: (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier) {
        items(
            items = list.value,
            key = { item -> item.id }
        ) { item ->
           HistoryItem(
               message1 = item.messagePart1,
               message2 = item.messagePart2,
               onClose = { onCloseTask(item) })
        }
    }
}