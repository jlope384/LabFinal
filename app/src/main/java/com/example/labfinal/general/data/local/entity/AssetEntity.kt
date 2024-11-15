package com.example.labfinal.general.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.labfinal.general.domain.model.Asset


@Entity(tableName = "AssetsEntity")
data class AssetEntity(
    @PrimaryKey val id: String,
    val name: String,
    val symbol: String,
    val priceUsd: String,
    val changePercent24Hr: String,
    val supply: String?,
    val maxSupply: String?,
    val marketCapUsd: String?,
    val lastUpdated: String // Fecha y hora de la última actualización
)

// Mapeo a modelo de negocio
fun AssetEntity.mapToAssetModel(): Asset {
    return Asset(
        id = id,
        name = name,
        symbol = symbol,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr,
        supply = supply,
        maxSupply = maxSupply,
        marketCapUsd = marketCapUsd,
    )
}
