package com.mundet.app_multiplatform.data.local

import com.mundet.app_multiplatform.domain.Either
import com.mundet.app_multiplatform.domain.Result
import com.mundet.app_multiplatform.domain.model.Poi

interface Local {
    fun hasPoi(): Boolean
    suspend fun getPoiList(): Either<Result.Error, List<Poi>>
    abstract fun savePois(poiList: List<Poi>) : Either<Result.Error, Result.Success>
}