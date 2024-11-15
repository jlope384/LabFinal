package com.example.labfinal.general.di

import android.content.Context
import androidx.room.Room
import com.example.labfinal.general.data.local.AssetsDatabase
import com.example.labfinal.general.data.network.HttpClientFactory
import io.ktor.client.HttpClient

object KtorDependencies {
    private var httpClient: HttpClient? = null
    private var localDb: AssetsDatabase? = null

    private fun buildHttpClient(): HttpClient = HttpClientFactory.create()

    private fun buildLocalDb(context: Context): AssetsDatabase {
        return Room.databaseBuilder(
            context,
            AssetsDatabase::class.java,
            "assets-db"
        ).build()
    }

    fun provideHttpClient(): HttpClient {
        return httpClient ?: synchronized(this) {
            httpClient ?: buildHttpClient().also { httpClient = it }
        }
    }

    fun provideLocalDb(context: Context): AssetsDatabase {
        return localDb ?: synchronized(this) {
            localDb ?: buildLocalDb(context).also { localDb = it }
        }
    }
}