package com.plcoding.doodlekong.util

import kotlinx.coroutines.CoroutineDispatcher

/**
 * interface is getting used here as usually to make testing easier
 * so we can inject a different DispatcherProvider in testing when needing a coroutine there that differs from production code
 */
interface DispatcherProvider {

    val main: CoroutineDispatcher
    val ioDispatcher: CoroutineDispatcher
    val defaultDispatcher: CoroutineDispatcher

}