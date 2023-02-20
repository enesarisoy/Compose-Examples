package com.ns.instagramclone.ui

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ns.instagramclone.data.Post
import com.ns.instagramclone.data.PostDataProvider
import com.ns.instagramclone.R
import com.ns.instagramclone.ui.posts.PostList
import com.ns.instagramclone.ui.stories.StoryList
import com.ns.instagramclone.ui.stories.StoryPopup

@Composable
fun InstagramHome(
    posts: List<Post>,
    profiles: List<Post>,
    onLikeClicked: () -> Unit,
    onCommentsClicked: () -> Unit,
    onSendClicked: () -> Unit,
    onProfileClicked: () -> Unit,
    onMessagingClicked: () -> Unit
) {
    var showStory = remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Instagram") },
                    backgroundColor = MaterialTheme.colors.surface,
                    contentColor = MaterialTheme.colors.onSurface,
                    elevation = 8.dp,
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_instagram),
                                contentDescription = null
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = onMessagingClicked) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_send),
                                contentDescription = "Go to messaging screen",
                            )
                        }
                    }
                )
            },
            content = { paddingValues ->
                Surface {
                    Column(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        StoryList(
                            profiles = profiles,
                            onProfileClicked = {
                                showStory.value = true
                                onProfileClicked.invoke()
                            }
                        )
                        Divider()
                        PostList(
                            posts = posts,
                            onLikeClicked = onLikeClicked,
                            onCommentsClicked = onCommentsClicked,
                            onSendClicked = onSendClicked
                        )
                    }
                }
            }
        )
        AnimatedVisibility(
            visible = showStory.value,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            StoryPopup(imageIds = PostDataProvider.itemList.take(5)) {
                showStory.value = false
            }
        }
    }
}

@Preview
@Composable
fun PreviewInstagramHome() {
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