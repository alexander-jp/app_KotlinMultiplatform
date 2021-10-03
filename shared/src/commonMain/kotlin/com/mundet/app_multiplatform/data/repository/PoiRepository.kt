package com.mundet.app_multiplatform.data.repository

import com.mundet.app_multiplatform.domain.Either
import com.mundet.app_multiplatform.domain.Result
import com.mundet.app_multiplatform.domain.model.Poi

interface PoiRepository {
    suspend fun getPoiList(force : Boolean = false) : Either<Result.Error, List<Poi>>
}