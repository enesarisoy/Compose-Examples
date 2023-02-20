package com.ns.spotifyclone.ui.search.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ns.spotifyclone.data.AlbumsDataProvider
import com.ns.spotifyclone.data.model.Album
import com.ns.spotifyclone.ui.detail.SpotifyDetailActivity
import com.ns.spotifyclone.utils.VerticalGrid
import com.ns.spotifyclone.utils.generateDominantColorState
import com.ns.spotifyclone.utils.horizontalGradientBackground

@Composable
fun SearchGrid() {
    val items = remember {
        AlbumsDataProvider.albums
    }
    VerticalGrid {
        items.forEach {
            SearchGridItems(album = it)
        }
    }
}

@Composable
fun SearchGridItems(album: Album) {
    val context = LocalContext.current
    val imageBitmap = ImageBitmap.imageResource(context.resources, album.imageId).asAndroidBitmap()
    val swatch = remember(album.id) {
        imageBitmap.generateDominantColorState()
    }
    val dominantGradient = remember {
        listOf(Color(swatch.rgb), Color(swatch.rgb).copy(alpha = 0.6f))
    }

    Row(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = {
                context.startActivity(SpotifyDetailActivity.newIntent(context, album))
            })
            .height(100.dp)
            .clip(RoundedCornerShape(8.dp))
            .horizontalGradientBackground(dominantGradient),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = album.song,
            style = MaterialTheme.typography.h6.copy(fontSize = 14.sp),
            modifier = Modifier.padding(8.dp)
        )
        Image(
            painter = painterResource(id = album.imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.Bottom)
                .graphicsLayer(translationX = 40f, rotationZ = 32f, shadowElevation = 16f)
        )
    }
}

@Preview
@Composable
fun PreviewSearchGrid() {
    SearchGrid()
}

