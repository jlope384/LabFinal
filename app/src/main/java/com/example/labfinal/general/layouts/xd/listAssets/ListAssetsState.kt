package com.example.labfinal.general.layouts.xd.listAssets

import com.example.labfinal.general.domain.model.Asset

data class ListAssetsState(
    val assets: List<Asset> = emptyList(),
    val isLoading: Boolean = false,
    val error: Throwable? = null
)