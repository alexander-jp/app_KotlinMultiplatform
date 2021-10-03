package com.mundet.app_multiplatform.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class PoisResponseDto(
    val list: List<PoiDto>
)