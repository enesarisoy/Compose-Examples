package com.ns.spotifyclone.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ns.spotifyclone.data.AlbumsDataProvider
import com.ns.spotifyclone.data.model.Album
import com.ns.spotifyclone.ui.detail.SpotifyDetailActivity

@Composable
fun SpotifyLaneItem(album: Album) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .width(180.dp)
            .padding(8.dp)
            .clickable(onClick = {
                context.startActivity(SpotifyDetailActivity.newIntent(context, album))
            })
    ) {

        Image(
            painter = painterResource(id = album.imageId),
            contentDescription = null,
            modifier = Modifier
                .width(180.dp)
                .height(160.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "${album.song}: ${album.descriptions}",
            style = MaterialTheme.typography.body2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Preview
@Composable
fun SpotifyLaneItemPreview() {
    val album = remember {
        AlbumsDataProvider.album
    }
    SpotifyLaneItem(album = album)
}