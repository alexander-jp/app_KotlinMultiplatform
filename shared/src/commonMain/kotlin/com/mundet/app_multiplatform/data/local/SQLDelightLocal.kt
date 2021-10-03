package com.mundet.app_multiplatform.data.local

import com.mundet.app_multiplatform.domain.Either
import com.mundet.app_multiplatform.domain.Result
import com.mundet.app_multiplatform.domain.model.Poi

class SQLDelightLocal : Local{
    override fun hasPoi(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getPoiList(): Either<Result.Error, List<Poi>> {
        TODO("Not yet implemented")
    }

    override fun savePois(poiList: List<Poi>): Either<Result.Error, Result.Success> {
        TODO("Not yet implemented")
    }
}