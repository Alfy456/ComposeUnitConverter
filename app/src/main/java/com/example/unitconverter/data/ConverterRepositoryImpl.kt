package com.example.unitconverter.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ConverterRepositoryImpl (private val converterDao: ConverterDao) : ConverterRepository {

    override suspend fun insertResult(conversionResult: ConversionResult) {
        converterDao.insertResult(conversionResult)
    }

    override suspend fun deleteResult(conversionResult: ConversionResult) {
       converterDao.deleteResult(conversionResult)
    }

    override suspend fun deleteAllResult() {
        converterDao.deleteAll()
    }

    override fun getSavedResults(): Flow<List<ConversionResult>> {
       return converterDao.getAllResult()
    }
}