package com.mundet.app_multiplatform.ui.executor

import kotlinx.coroutines.CoroutineDispatcher

expect class Executor {
    val main : CoroutineDispatcher
    val io : CoroutineDispatcher
}