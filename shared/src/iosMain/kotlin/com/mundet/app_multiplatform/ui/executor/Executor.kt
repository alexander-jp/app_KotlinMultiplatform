package com.mundet.app_multiplatform.ui.executor

import kotlinx.coroutines.CoroutineDispatcher

actual class Executor {
    actual val main: CoroutineDispatcher
        get() = TODO("Not yet implemented")
    actual val io: CoroutineDispatcher
        get() = TODO("Not yet implemented")
}