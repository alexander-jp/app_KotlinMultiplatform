package com.mundet.app_multiplatform.data.model.dto

import com.mundet.app_multiplatform.domain.model.Poi
import kotlinx.serialization.Serializable

@Serializable
data class PoiDto(
    val geocoordinates: String,
    val id: String,
    val title: String
)


fun PoiDto.toModel() = Poi(
    id = id,
    title = title,
    latitude = geocoordinates.split(",")[0].toDoubleOrNull()?:0.0,
    longitude = geocoordinates.split(",")[1].toDoubleOrNull()?:0.0,
)