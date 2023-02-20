package com.ns.spotifyclone.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ns.spotifyclone.R
import com.ns.spotifyclone.ui.theme.SpotifyCloneTheme
import com.ns.spotifyclone.ui.theme.graySurface

@Composable
fun SongBottomBar(modifier: Modifier) {
    val bottomBarHeight = 5.dp
    val backgroundColor =
        if (isSystemInDarkTheme()) graySurface else MaterialTheme.colors.background

    Row(
        modifier = modifier
            .padding(bottom = bottomBarHeight)
            .fillMaxWidth()
            .height(65.dp)
            .background(color = backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.adele21),
            contentDescription = null,
            modifier = Modifier.size(40.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = modifier.width(8.dp))
        Text(
            text = "Someone Like You by Adele",
            style = MaterialTheme.typography.h6.copy(fontSize = 14.sp),
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
        )
        Icon(
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = null,
            modifier = Modifier.padding(8.dp)
        )
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = null,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun SongBottomBarPreview() {
    SpotifyCloneTheme {
        SongBottomBar(Modifier)
    }
}