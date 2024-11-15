package com.example.labfinal.general.layouts.xd

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.labfinal.general.layouts.xd.assetProfile.AssetProfile
import com.example.labfinal.general.layouts.xd.assetProfile.navigateToAssetProfile
import com.example.labfinal.general.layouts.xd.listAssets.ListAssets
import com.example.labfinal.general.layouts.xd.listAssets.ListAssetsDestination

@Composable
fun AssetNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = ListAssetsDestination,
        modifier = modifier) {
        ListAssets(navigateToAssetProfile = navController::navigateToAssetProfile)
        AssetProfile(onNavigateBack = navController::popBackStack)
    }
}

@Preview
@Composable
fun AssetNavHostPreview() {
    AssetNavHost()
}