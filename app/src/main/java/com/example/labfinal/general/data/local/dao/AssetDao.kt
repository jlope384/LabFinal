package com.example.labfinal.general.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.labfinal.general.data.local.entity.AssetEntity
import com.example.labfinal.general.data.network.dto.dto.EntryListDto

@Dao
interface AssetDao {
    @Query("SELECT * FROM AssetsEntity")
    suspend fun getAllAssets(): List<AssetEntity>

    @Upsert
    suspend fun insertAssets(assets: Result<EntryListDto>)

    @Query("SELECT * FROM AssetsEntity WHERE id = :id")
    suspend fun getAssetById(id: String): AssetEntity

    @Query("SELECT lastUpdated FROM AssetsEntity LIMIT 1")
    suspend fun getLastUpdated(): String?
}
