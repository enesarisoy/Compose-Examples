package com.ns.instagramclone.ui.posts

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ns.instagramclone.data.PostDataProvider

@Composable
fun PostImage(
    @DrawableRes imageId: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = contentDescription,
        modifier = modifier
            .fillMaxWidth()
            .height(450.dp),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun PostImagePreview() {
    PostImage(
        imageId = PostDataProvider.postList.first { it.postImageId != 0 }.postImageId,
        contentDescription = null
    )
}