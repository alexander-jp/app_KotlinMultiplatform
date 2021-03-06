package com.mundet.app_multiplatform.ui.presenter

import com.mundet.app_multiplatform.domain.Either
import com.mundet.app_multiplatform.domain.Result
import com.mundet.app_multiplatform.ui.executor.Executor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.withContext

abstract class Presenter<out V : View>(
    val executor: Executor,
    val view: V
) {

    private val job = SupervisorJob()
    protected val scope = CoroutineScope(job + executor.main)
    protected suspend fun <T> execute(block: suspend () -> Either<Result.Error, T>) =
        withContext(executor.io) { block() }

    abstract fun attach()

    fun detach() = job.cancel()
}

interface View {
    fun showProgress()
    fun hideProgress()
}