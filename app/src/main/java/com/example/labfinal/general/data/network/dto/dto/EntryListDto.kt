package com.example.labfinal.general.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class EntryListDto(
    val data: List<EntryDto>
)
