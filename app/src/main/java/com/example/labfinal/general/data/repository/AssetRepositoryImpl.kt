package com.example.labfinal.general.data.repository

import com.example.labfinal.general.data.local.dao.AssetDao
import com.example.labfinal.general.data.local.entity.mapToAssetModel
import com.example.labfinal.general.data.local.entity.mapToAssetEntity
import com.example.labfinal.general.data.network.dto.dto.mapToAssetModel
import com.example.labfinal.general.domain.model.Asset
import com.example.labfinal.general.domain.model.DataError
import com.example.labfinal.general.domain.network.CoinCapApi
import com.example.labfinal.general.domain.network.util.Result
import com.example.labfinal.general.domain.repository.AssetsRepository

class AssetRepositoryImpl(
    private val api: CoinCapApi,
    private val assetDao: AssetDao
) : AssetsRepository {

    override suspend fun getAssets(): Result<List<Any>, DataError> {
        return when (val result = api.getAssets()) {
            is Result.Error -> {
                val localAssets = assetDao.getAllAssets().map { it.mapToAssetModel() }
                if (localAssets.isEmpty()) {
                    Result.Error(DataError.NO_INTERNET)
                } else {
                    Result.Success(localAssets)
                }
            }
            is Result.Success -> {
                val remoteAssets = result.data.data
                assetDao.insertAssets(remoteAssets.map { it.mapToAssetEntity() })
                Result.Success(remoteAssets.map { it.mapToAssetModel() })
            }
        }
    }

    override suspend fun getAssetProfile(assetId: String): Result<Asset, DataError> {
        val localAsset = assetDao.getAssetById(assetId)?.mapToAssetModel()
        return localAsset?.let {
            Result.Success(it)
        } ?: Result.Error(DataError.GENERIC_ERROR)
    }

    suspend fun getLocalAssets(): List<Asset> {
        return assetDao.getAllAssets().map { it.mapToAssetModel() }
    }
}
