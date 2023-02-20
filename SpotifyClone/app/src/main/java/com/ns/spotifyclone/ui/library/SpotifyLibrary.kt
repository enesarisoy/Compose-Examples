package com.ns.spotifyclone.ui.library

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ns.spotifyclone.data.AlbumsDataProvider
import com.ns.spotifyclone.data.GradientDataProvider
import com.ns.spotifyclone.data.model.Album
import com.ns.spotifyclone.ui.detail.SpotifyDetailActivity
import com.ns.spotifyclone.ui.home.components.SpotifyTitle
import com.ns.spotifyclone.utils.StaggeredVerticalGrid
import com.ns.spotifyclone.utils.horizontalGradientBackground
import kotlin.random.Random

@Composable
fun SpotifyLibrary() {
    val albums = remember {
        AlbumsDataProvider.albums
    }
    val surfaceGradient = GradientDataProvider.spotifySurfaceGradient(isSystemInDarkTheme())
    val context = LocalContext.current

    LazyColumn(modifier = Modifier.horizontalGradientBackground(surfaceGradient)) {
        item { Spacer(modifier = Modifier.height(50.dp)) }
        item { SpotifyTitle(text = "Your Library") }
        item { Spacer(modifier = Modifier.height(20.dp)) }
        item {
            StaggeredVerticalGrid(maxColumnWidth = 250.dp) {
                albums.forEach {
                    LibraryItemWithRandomHeight(it, context)
                }
            }
        }
    }

}

@Composable
fun LibraryItemWithRandomHeight(album: Album, context: Context) {
    val randomHeight = remember(album.id) {
        Random.nextInt(180, 380).dp
    }

    Card(
        elevation = 8.dp, modifier = Modifier
            .padding(6.dp)
            .clickable(onClick = {
                context.startActivity(SpotifyDetailActivity.newIntent(context, album))
            })
    ) {
        Column {
            Image(
                painter = painterResource(id = album.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(randomHeight)
            )
            Text(
                text = album.artist,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h6.copy(fontSize = 14.sp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewSpotifyLibrary() {
    SpotifyLibrary()
}