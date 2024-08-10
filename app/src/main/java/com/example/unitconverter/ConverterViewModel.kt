package com.example.unitconverter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.unitconverter.data.Conversion
import com.example.unitconverter.data.ConversionResult
import com.example.unitconverter.data.ConverterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConverterViewModel(private val repository: ConverterRepository): ViewModel() {

    val selectedConversion : MutableState<Conversion?> =
        mutableStateOf(null)


    val inputText: MutableState<String> =
        mutableStateOf("")

    val typedValue =
        mutableStateOf("0.0")


    fun getConversions() = listOf(
        Conversion(1,"Pounds to kilograms","lbs","kg",0.453592),
        Conversion(1,"Kilograms to Pounds","kg","lbs",2.20462),
        Conversion(1,"Miles  to Kilometers","mi","km",1.60934),
        Conversion(1,"Kilometers to miles","km","mi",0.621371),
    )

    val resultList = repository.getSavedResults()

    fun addResult(message1:String,message2:String){
       viewModelScope.launch(Dispatchers.IO) {
           repository.insertResult(ConversionResult(0,message1,message2))
       }
    }

    fun deleteResult(conversionResult: ConversionResult){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResult(conversionResult)
        }
    }

    fun deleteAll(){
       viewModelScope.launch(Dispatchers.IO) {
           repository.deleteAllResult()
       }
    }


}