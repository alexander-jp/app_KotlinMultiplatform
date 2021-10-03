package com.mundet.app_multiplatform.data.local

import com.mundet.app_multiplatform.domain.Either
import com.mundet.app_multiplatform.domain.Result
import com.mundet.app_multiplatform.domain.model.Poi
import com.mundet.app_multiplatform.pois
import com.mundet.app_multiplatform.withEither
import com.mundet.appmultiplatform.PoiVo
import com.squareup.sqldelight.db.SqlDriver

expect class DbDriver {
    fun get() : SqlDriver
}

class SQLDelightLocal (driver: DbDriver) : Local{

    private val db by lazy { pois(driver = driver.get()) }

    override fun hasPoi(): Boolean = db.poiQueries.selectAll().executeAsList().isNotEmpty()


    override suspend fun getPoiList(): Either<Result.Error, List<Poi>> =
        withEither {
            db.poiQueries.selectAll().executeAsList().map {
                it.toModel()
            }

    }

    override suspend fun savePois(poiList: List<Poi>): Either<Result.Error, Result.Success> = withEither {

        db.poiQueries.transaction {
            poiList.forEach {
                db.poiQueries.addOrUpdate(it.toVo())
            }
        }
        Result.Success
    }

    fun Poi.toVo () = PoiVo(id, title, latitude, longitude)
    fun PoiVo.toModel() = Poi(id?:"",title?:"", latitude?:0.0,longitude?:0.0)
}