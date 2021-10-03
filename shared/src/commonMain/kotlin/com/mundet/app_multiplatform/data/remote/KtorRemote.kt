package com.mundet.app_multiplatform.data.remote

import com.mundet.app_multiplatform.data.model.dto.PoisResponseDto
import com.mundet.app_multiplatform.data.model.dto.toModel
import com.mundet.app_multiplatform.domain.Either
import com.mundet.app_multiplatform.domain.Result
import com.mundet.app_multiplatform.domain.model.Poi
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

class KtorRemote : Remote {

    val client = HttpClient {
        defaultRequest {
            val endPointBuilder = URLBuilder("https://t21services.herokuapp.com/")
            url {
                protocol = endPointBuilder.protocol
                host = endPointBuilder.host
            }
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    override suspend fun getPoiList(): Either<Result.Error, List<Poi>> = withEither {
        val response = client.get<PoisResponseDto> { url { encodedPath = "points" } }
        response.list.map { it.toModel() }
    }

    private suspend fun <T> withEither(block: suspend () -> T): Either<Result.Error, T> = try {
        Either.Right(block())
    } catch (e: Exception) {
        Either.Left(Result.Error.Default)
    }

}