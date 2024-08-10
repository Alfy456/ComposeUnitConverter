package com.example.unitconverter.data

import kotlinx.coroutines.flow.Flow

interface ConverterRepository  {

    suspend fun insertResult(conversionResult: ConversionResult)
    suspend fun deleteResult(conversionResult: ConversionResult)
    suspend fun deleteAllResult()

    fun getSavedResults(): Flow<List<ConversionResult>>
}