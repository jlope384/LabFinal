package com.example.labfinal.general.layouts.xd.assetProfile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CryptoAssetDetails(
    val name: String,
    val symbol: String,
    val priceUsd: String,
    val changePercent24Hr: String,
    val supply: String,
    val maxSupply: String?,
    val marketCapUsd: String,
    val lastUpdated: String // Fecha y hora de actualización
)

@Composable
fun AssetProfileRoute(onNavigateBack: () -> Unit) {
    val assetDetails = CryptoAssetDetails(
        name = "Bitcoin",
        symbol = "BTC",
        priceUsd = "50000",
        changePercent24Hr = "5",
        supply = "1000000",
        maxSupply = "21000000",
        marketCapUsd = "50000000000",
        lastUpdated = "2021-09-01 12:00:00"
    )

    AssetProfileScreen(assetDetails = assetDetails)
}


@Composable
fun AssetProfileScreen(
    assetDetails: CryptoAssetDetails,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Asset Profile",
            style = MaterialTheme.typography.headlineLarge.copy(fontSize = 24.sp),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // Información básica
        InfoRow(label = "Name", value = assetDetails.name)
        InfoRow(label = "Symbol", value = assetDetails.symbol)
        InfoRow(label = "Price (USD)", value = "$${assetDetails.priceUsd}")

        // Cambio porcentual con indicador visual
        InfoRow(
            label = "Change (24H)",
            value = "${assetDetails.changePercent24Hr}%",
            valueColor = if (assetDetails.changePercent24Hr.toDouble() >= 0) Color.Green else Color.Red
        )

        // Información adicional
        InfoRow(label = "Supply", value = assetDetails.supply)
        InfoRow(
            label = "Max Supply",
            value = assetDetails.maxSupply ?: "No Data Available"
        )
        InfoRow(label = "Market Cap (USD)", value = "$${assetDetails.marketCapUsd}")

        // Fecha de actualización
        InfoRow(label = "Last Updated", value = assetDetails.lastUpdated)
    }
}

@Composable
fun InfoRow(
    label: String,
    value: String,
    valueColor: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = valueColor,
            textAlign = TextAlign.End,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun AssetProfileScreenPreview() {
    AssetProfileScreen(
        assetDetails = CryptoAssetDetails(
            name = "Bitcoin",
            symbol = "BTC",
            priceUsd = "50000",
            changePercent24Hr = "5",
            supply = "1000000",
            maxSupply = "21000000",
            marketCapUsd = "50000000000",
            lastUpdated = "2021-09-01 12:00:00"
        )
    )
}