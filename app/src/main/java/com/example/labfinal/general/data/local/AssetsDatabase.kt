package com.example.labfinal.general.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.labfinal.general.data.local.dao.AssetDao
import com.example.labfinal.general.data.local.entity.AssetEntity

@Database(
    entities = [AssetEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AssetsDatabase : RoomDatabase() {
    abstract fun assetDao(): AssetDao
}
