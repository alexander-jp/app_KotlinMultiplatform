package com.mundet.app_multiplatform.data.repository

import com.mundet.app_multiplatform.data.local.Local
import com.mundet.app_multiplatform.data.remote.Remote
import com.mundet.app_multiplatform.domain.Either
import com.mundet.app_multiplatform.domain.Result
import com.mundet.app_multiplatform.domain.model.Poi

class CommonPoiRepository(
    private val local: Local,
    private val remote: Remote
) : PoiRepository {

    override suspend fun getPoiList(force: Boolean): Either<Result.Error, List<Poi>> {
        val remoteAndSave = remote.getPoiList().flatMap {
            local.savePois(it.success)
            it
        }
        return when (force) {
            true -> remoteAndSave
            false -> when (local.hasPoi()) {
                true -> local.getPoiList()
                false -> remoteAndSave
            }
        }
    }


}