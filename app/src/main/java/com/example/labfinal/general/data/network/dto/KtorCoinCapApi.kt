package com.example.labfinal.general.data.network

import com.example.labfinal.general.data.network.dto.EntryListDto
import com.example.labfinal.general.data.network.dto.EntryProfileDto
import com.example.labfinal.general.data.network.util.safeCall
import com.example.labfinal.general.domain.network.CoinCapApi
import com.example.labfinal.general.domain.network.util.NetworkError
import com.example.labfinal.general.domain.network.util.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class KtorCoinCapApi(
    private val httpClient: HttpClient
) : CoinCapApi {

    override suspend fun getAssets(): Result<EntryListDto, NetworkError> {
        return safeCall {
            httpClient.get("https://api.coincap.io/v2/assets")
        }
    }

    suspend fun getAssetById(id: String): Result<EntryProfileDto, NetworkError> {
        return safeCall {
            httpClient.get("https://api.coincap.io/v2/assets/$id")
        }
    }
}
