package com.ns.spotifyclone.ui.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ns.spotifyclone.data.AlbumsDataProvider
import com.ns.spotifyclone.ui.theme.SpotifyCloneTheme
import com.ns.spotifyclone.ui.theme.green700

@Composable
fun SongListScrollingSection() {
    ShuffleButton()
    DownloadedRow()
    val items = remember {
        AlbumsDataProvider.albums
    }
    items.forEach {
        SpotifySongListItem(album = it)
    }
}

@Composable
fun ShuffleButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = green700),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 100.dp)
            .clip(CircleShape)
    ) {
        Text(
            text = "SHUFFLE PLAY",
            style = MaterialTheme.typography.h6.copy(fontSize = 14.sp),
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}

@Composable
fun DownloadedRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Downloaded",
            style = typography.h6.copy(fontSize = 14.sp),
            color = colors.onSurface
        )
        var switched by remember {
            mutableStateOf(true)
        }
        Switch(
            checked = switched,
            onCheckedChange = { switched = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colors.primary,
            ),
            modifier = Modifier.padding(8.dp)
        )


    }
}