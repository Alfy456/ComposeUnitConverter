package com.example.unitconverter.di.module

import androidx.room.Room

import com.example.unitconverter.data.ConverterDatabase
import com.example.unitconverter.data.ConverterRepository
import com.example.unitconverter.data.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Provides
//    @Singleton
//    fun providesConverterDatabase(app:App): ConverterDatabase {
//
//        return Room.databaseBuilder(
//            app,
//            ConverterDatabase::class.java,
//            "converter_data_base"
//        ).build()
//    }
//
//    @Provides
//    @Singleton
//    fun providesConverterRepository(db:ConverterDatabase) : ConverterRepository{
//        return ConverterRepositoryImpl(db.converterDao)
//
//    }
//}