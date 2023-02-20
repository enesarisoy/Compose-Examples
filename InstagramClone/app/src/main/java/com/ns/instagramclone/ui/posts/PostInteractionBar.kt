package com.ns.instagramclone.ui.posts

import androidx.compose.foundation.layout.Row
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

@Composable
fun PostInteractionBar(
    isLiked: Boolean,
    onLikeClicked: () -> Unit,
    onCommentsClicked: () -> Unit,
    onSendClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        IconToggleButton(checked = isLiked, onCheckedChange = { onLikeClicked() }) {
            val icon = if (isLiked) FaIcons.Heart else FaIcons.HeartRegular
            val tint = if (isLiked) Color.Red else MaterialTheme.colors.onPrimary
            FaIcon(faIcon = icon, tint = tint)
        }
        IconToggleButton(checked = false, onCheckedChange = { onCommentsClicked() }) {
            FaIcon(faIcon = FaIcons.CommentAltRegular, tint = MaterialTheme.colors.onPrimary)
        }
        IconToggleButton(checked = false, onCheckedChange = { onSendClicked() }) {
            FaIcon(faIcon = FaIcons.PaperPlaneRegular, tint = MaterialTheme.colors.onPrimary)
        }
    }
}

@Preview
@Composable
fun PostInteractionBarPreview() {
    PostInteractionBar(
        isLiked = true,
        onLikeClicked = {},
        onCommentsClicked = {},
        onSendClicked = {}
    )
}