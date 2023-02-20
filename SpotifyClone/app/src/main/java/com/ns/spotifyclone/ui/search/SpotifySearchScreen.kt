package com.ns.spotifyclone.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ns.spotifyclone.data.GradientDataProvider
import com.ns.spotifyclone.ui.search.components.SearchBar
import com.ns.spotifyclone.ui.search.components.SearchGrid
import com.ns.spotifyclone.ui.theme.graySurface
import com.ns.spotifyclone.utils.horizontalGradientBackground

@Composable
fun SpotifySearchScreen() {
    val scrollState = rememberScrollState(0)
    val backgroundColor =
        if (isSystemInDarkTheme()) graySurface else MaterialTheme.colors.background

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {

        Column(modifier = Modifier.verticalScroll(scrollState)) {
            Text(
                text = "Search",
                style = MaterialTheme.typography.h3.copy(fontWeight = FontWeight.ExtraBold),
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(top = 80.dp, bottom = 40.dp)
                    .fillMaxSize()
                    .alpha(1f - scrollState.value / 200)
            )
            SearchBar()
            SearchGrid()
            Spacer(modifier = Modifier.height(200.dp))
        }
    }

}

@Preview
@Composable
fun PreviewSpotifySearchScreen() {
    SpotifySearchScreen()
}