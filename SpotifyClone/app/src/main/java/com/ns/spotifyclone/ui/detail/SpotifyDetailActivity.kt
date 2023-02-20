package com.ns.spotifyclone.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.ns.spotifyclone.data.AlbumsDataProvider
import com.ns.spotifyclone.data.model.Album
import com.ns.spotifyclone.ui.detail.ui.theme.SpotifyCloneTheme

class SpotifyDetailActivity : ComponentActivity() {
    private val album: Album by lazy {
        intent?.getSerializableExtra(ALBUM) as Album
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        setContent {
            com.ns.spotifyclone.ui.theme.SpotifyCloneTheme {
                SpotifyDetailScreen(album = album)
            }
        }
    }

    companion object {
        const val ALBUM = "album"

        fun newIntent(context: Context, album: Album) =
            Intent(context, SpotifyDetailActivity::class.java).apply {
                putExtra(ALBUM, album)
            }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSpotifyDetailActivity() {
    val album = AlbumsDataProvider.album
    com.ns.spotifyclone.ui.theme.SpotifyCloneTheme() {
        SpotifyDetailScreen(album)
    }
}