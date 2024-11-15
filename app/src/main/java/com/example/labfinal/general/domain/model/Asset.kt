package com.example.labfinal.general.domain.model

data class Asset(
    val id: String,
    val name: String,
    val symbol: String,
    val priceUsd: String,
    val changePercent24Hr: String,
    val supply: String? = null,
    val maxSupply: String? = null,
    val marketCapUsd: String? = null,
)