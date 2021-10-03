package com.mundet.app_multiplatform.data.remote

import com.mundet.app_multiplatform.domain.Either
import com.mundet.app_multiplatform.domain.Result
import com.mundet.app_multiplatform.domain.model.Poi

class KtorRemote : Remote {

    override suspend fun getPoiList(): Either<Result.Error, List<Poi>> {
        TODO("Not yet implemented")
    }
}