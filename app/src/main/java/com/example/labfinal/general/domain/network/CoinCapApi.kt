package com.example.labfinal.general.domain.network

import com.example.labfinal.general.data.network.dto.dto.EntryListDto
import com.example.labfinal.general.data.network.dto.dto.EntryProfileDto
import com.example.labfinal.general.domain.model.Asset
import com.example.labfinal.general.domain.network.util.NetworkError
import com.example.labfinal.general.domain.network.util.Result

interface CoinCapApi {
    suspend fun getAssets(): Result<EntryListDto, NetworkError>
    suspend fun getAssetProfile(assetId: String): Result<EntryProfileDto, NetworkError>

}