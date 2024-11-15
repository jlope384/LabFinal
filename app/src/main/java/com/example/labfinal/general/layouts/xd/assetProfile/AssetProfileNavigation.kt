package com.example.labfinal.general.layouts.xd.assetProfile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data class AssetProfileDestination(
    val assetId: String
)

fun NavController.navigateToAssetProfile(assetId: String) {
    this.navigate(AssetProfileDestination(assetId))
}

fun NavGraphBuilder.AssetProfile(
    onNavigateBack: () -> Unit
) {
    composable<AssetProfileDestination> {
        AssetProfileRoute(onNavigateBack = onNavigateBack)
    }
}