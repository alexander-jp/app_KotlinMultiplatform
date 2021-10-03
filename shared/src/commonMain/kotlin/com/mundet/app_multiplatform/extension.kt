package com.mundet.app_multiplatform

import com.mundet.app_multiplatform.domain.Either
import com.mundet.app_multiplatform.domain.Result

suspend fun <T> withEither(block: suspend () -> T): Either<Result.Error, T> = try {
    Either.Right(block())
} catch (e: Exception) {
    Either.Left(Result.Error.Default)
}