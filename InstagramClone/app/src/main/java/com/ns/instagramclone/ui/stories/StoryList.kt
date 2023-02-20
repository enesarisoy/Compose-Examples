package com.ns.instagramclone.ui.stories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ns.instagramclone.data.Post
import com.ns.instagramclone.data.PostDataProvider

@Composable
fun StoryList(
    profiles: List<Post>,
    onProfileClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(profiles) {
            StoryItem(
                profileImageId = it.authorImageId,
                profileName = it.author,
                isMe = it.id == 1,
                onClick = onProfileClicked
            )
        }
    }

}

@Preview
@Composable
fun StoryListPreview() {
    val list = PostDataProvider.postList
    StoryList(profiles = list, onProfileClicked = { /*TODO*/ })
}