package com.ns.instagramclone.ui.posts

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ns.instagramclone.data.Post
import com.ns.instagramclone.data.PostDataProvider
import kotlin.random.Random

@Composable
fun PostList(
    posts: List<Post>,
    onLikeClicked: () -> Unit,
    onCommentsClicked: () -> Unit,
    onSendClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(posts) {
            PostItem(
                post = it,
                isLiked = Random.nextBoolean(),
                onLikeClicked = onLikeClicked,
                onCommentsClicked = onCommentsClicked,
                onSendClicked = onSendClicked
            )
        }
    }
}
