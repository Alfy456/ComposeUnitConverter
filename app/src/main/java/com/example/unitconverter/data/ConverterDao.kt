package com.example.unitconverter.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConverterDao {

    @Insert
    suspend fun insertResult(result: ConversionResult)

    @Delete
    suspend fun deleteResult(result: ConversionResult)

    @Query("delete from conversion_result")
    suspend fun deleteAll()

    @Query("select * from conversion_result")
    fun getAllResult(): Flow<List<ConversionResult>>
}