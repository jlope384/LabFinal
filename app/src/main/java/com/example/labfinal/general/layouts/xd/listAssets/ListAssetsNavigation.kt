package com.example.labfinal.general.layouts.xd.listAssets

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ListAssetsDestination

fun NavGraphBuilder.ListAssets(
    navigateToAssetProfile: (String) -> Unit
) {
    composable<ListAssetsDestination> {
        ListAssetsRoute(
            OnProfileClick = navigateToAssetProfile
        )
    }
}