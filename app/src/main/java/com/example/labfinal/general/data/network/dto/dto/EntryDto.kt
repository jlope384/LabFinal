package com.example.labfinal.general.data.network.dto

import com.example.labfinal.general.data.local.entity.AssetEntity
import com.example.labfinal.general.domain.model.Asset
import kotlinx.serialization.Serializable

@Serializable
data class EntryDto(
    val id: String,
    val name: String,
    val symbol: String,
    val priceUsd: String,
    val changePercent24Hr: String,
    val supply: String? = null,
    val maxSupply: String? = null,
    val marketCapUsd: String? = null
)

// Mapping to domain model
fun EntryDto.mapToAssetModel(): Asset {
    return Asset(
        id = id,
        name = name,
        symbol = symbol,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr,
        supply = supply,
        maxSupply = maxSupply,
        marketCapUsd = marketCapUsd
    )
}

// Mapping to local entity
fun EntryDto.mapToAssetEntity(): AssetEntity {
    return AssetEntity(
        id = id,
        name = name,
        symbol = symbol,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr,
        supply = supply,
        maxSupply = maxSupply,
        marketCapUsd = marketCapUsd,
        lastUpdated = System.currentTimeMillis().toString()
    )
}
