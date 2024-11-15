package com.example.labfinal.general.layouts.xd.listAssets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListAssetsRoute(OnProfileClick: (String) -> Unit) {
    // Datos de ejemplo
    val sampleAssets = remember {
        listOf(
            CryptoAsset("Bitcoin", "BTC", "50,000", "5.0"),
            CryptoAsset("Ethereum", "ETH", "3,000", "-2.0"),
            CryptoAsset("Cardano", "ADA", "2.5", "0.0"),
            CryptoAsset("Ripple", "XRP", "1.2", "-1.5")
        )
    }

    // Pantalla principal con callback de clic
    ListAssetsScreen(
        assets = sampleAssets,
        modifier = Modifier.fillMaxSize(),
        onItemClick = { symbol -> OnProfileClick(symbol) }
    )
}


data class CryptoAsset(
    val name: String,
    val symbol: String,
    val priceUsd: String,
    val changePercent24Hr: String
)

@Composable
fun ListAssetsScreen(
    assets: List<CryptoAsset>,
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(assets.size) { index ->
            val asset = assets[index]
            CryptoAssetItem(asset, onItemClick = onItemClick)
        }
    }
}


@Composable
fun CryptoAssetItem(
    asset: CryptoAsset,
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick(asset.symbol) }, // Llama al callback al hacer clic
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = asset.name,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                    color = Color.Black
                )
                Text(
                    text = asset.symbol,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "$${asset.priceUsd}",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                    color = Color.Black,
                    textAlign = TextAlign.End
                )
                Text(
                    text = "${asset.changePercent24Hr}%",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (asset.changePercent24Hr.toDouble() >= 0) Color.Green else Color.Red,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}


@Preview
@Composable
fun ListAssetsScreenPreview() {
    ListAssetsRoute(OnProfileClick = {})
}
