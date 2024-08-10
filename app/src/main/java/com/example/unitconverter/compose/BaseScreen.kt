package com.example.unitconverter.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverter.ConverterViewModel
import com.example.unitconverter.ConverterViewModelFactory

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
){

    val list = converterViewModel.getConversions()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())

    val configuration = LocalConfiguration.current
    var isLandscape by remember {
        mutableStateOf(false)
    }



    when(configuration.orientation){
        Configuration.ORIENTATION_LANDSCAPE -> {
            isLandscape = true
            Row(modifier = Modifier
                .padding(30.dp)
                .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround) {
                TopScreen(list,
                    converterViewModel.selectedConversion,
                    converterViewModel.inputText,
                    converterViewModel.typedValue,
                    isLandscape

                ){ message1,message2 ->
                    converterViewModel.addResult(message1,message2)

                }
                Spacer(modifier = Modifier.width(10.dp))
                HistoryScreen(historyList,{item ->
                    converterViewModel.deleteResult(item)

                },
                    {
                        converterViewModel.deleteAll()
                    })

            }
        }else ->{
            isLandscape = false
            Column(modifier = Modifier.padding(30.dp)) {
            TopScreen(list,
                converterViewModel.selectedConversion,
                converterViewModel.inputText,
                converterViewModel.typedValue,
                isLandscape

            ){ message1,message2 ->
                converterViewModel.addResult(message1,message2)

            }
            Spacer(modifier = Modifier.height(20.dp))
            HistoryScreen(historyList,{item ->
                converterViewModel.deleteResult(item)

            },
                {
                    converterViewModel.deleteAll()
                })

        }
        }
    }


}