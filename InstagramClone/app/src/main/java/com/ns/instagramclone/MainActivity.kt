package com.ns.instagramclone

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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ns.instagramclone.data.PostDataProvider
import com.ns.instagramclone.ui.InstagramHome
import com.ns.instagramclone.ui.theme.InstagramCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val posts = remember { PostDataProvider.postList.filter { it.postImageId != 0 } }
            val profiles = remember { PostDataProvider.postList }
            InstagramCloneTheme {
                InstagramHome(
                    posts = posts,
                    profiles = profiles,
                    onLikeClicked = {},
                    onCommentsClicked = {},
                    onSendClicked = {},
                    onProfileClicked = {},
                    onMessagingClicked = {}
                )
            }
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InstagramCloneTheme() {
        InstagramHome(
            posts = PostDataProvider.postList.filter { it.postImageId != 0 },
            profiles = PostDataProvider.postList,
            onLikeClicked = {},
            onCommentsClicked = {},
            onSendClicked = {},
            onProfileClicked = {},
            onMessagingClicked = {}
        )
    }
}
