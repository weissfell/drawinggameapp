package com.plcoding.doodlekong.di

import com.google.gson.Gson
import com.plcoding.doodlekong.util.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

/**
 * central place to define dependencies for later injection... -> called modules
 */
@Module
@InstallIn(SingletonComponent::class) // tell Hilt that dependencies should exist in form of singletons
object AppModule {

    /**
     * returns singleton client
     */
    @Singleton
    @Provides
    fun provideOkHttoClient(): OkHttpClient {
        return OkHttpClient.Builder()
            //interceptor will modify every single request that gets sent through this client
            // in this case just logging..
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Singleton
    @Provides
    fun provideGsonInstance(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider {
        return object : DispatcherProvider {
            override val main: CoroutineDispatcher
                get() = Dispatchers.Main
                //alternative in case this Provider gets an alternative implmenetation for testing:
                // get() = TestCoroutineDispatcher()
            override val ioDispatcher: CoroutineDispatcher
                get() = Dispatchers.IO
            override val defaultDispatcher: CoroutineDispatcher
                get() = Dispatchers.Default
        }
    }
}