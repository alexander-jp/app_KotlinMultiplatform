package com.mundet.app_multiplatform.data.remote

import com.mundet.app_multiplatform.domain.Either
import com.mundet.app_multiplatform.domain.Result
import com.mundet.app_multiplatform.domain.model.Poi
import com.mundet.app_multiplatform.ui.presenter.PoiListPresenter

interface Remote {
    suspend fun getPoiList(): Either<Result.Error, List<Poi>>
}