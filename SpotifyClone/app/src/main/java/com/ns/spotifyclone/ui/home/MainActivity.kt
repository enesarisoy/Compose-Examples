package com.ns.spotifyclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ns.spotifyclone.ui.home.components.SpotifyHome
import com.ns.spotifyclone.ui.library.SpotifyLibrary
import com.ns.spotifyclone.ui.search.SpotifySearchScreen
import com.ns.spotifyclone.ui.theme.SpotifyCloneTheme
import com.ns.spotifyclone.ui.theme.graySurface
import com.ns.spotifyclone.utils.LibraryMusic

enum class NavType {
    HOME, SEARCH, LIBRARY
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyCloneTheme {
                SpotifyAppContent()
            }
        }
    }
}

@Composable
fun SpotifyAppContent() {
    val navItemState = rememberSaveable() {
        mutableStateOf(NavType.HOME)
    }
    Scaffold(
        bottomBar = { SpotifyBottomNavigation(navItemState) },
        content = { paddingValues ->
            SpotifyBodyContent(
                navType = navItemState.value,
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}

@Composable
fun SpotifyBottomNavigation(
    navItemState: MutableState<NavType>
) {
    val bottomNavBackground =
        if (isSystemInDarkTheme()) graySurface else MaterialTheme.colors.background

    BottomNavigation(backgroundColor = bottomNavBackground) {
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = null) },
            selected = navItemState.value == NavType.HOME,
            onClick = { navItemState.value = NavType.HOME },
            label = { Text(text = stringResource(id = R.string.spotify_nav_home)) }
        )

        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Outlined.Search, contentDescription = null) },
            selected = navItemState.value == NavType.SEARCH,
            onClick = { navItemState.value = NavType.SEARCH },
            label = { Text(text = stringResource(id = R.string.spotify_nav_search)) }
        )

        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Outlined.LibraryMusic, contentDescription = null) },
            selected = navItemState.value == NavType.LIBRARY,
            onClick = { navItemState.value = NavType.LIBRARY },
            label = { Text(text = stringResource(id = R.string.spotify_nav_library)) }
        )
    }
}

@Composable
fun SpotifyBodyContent(
    navType: NavType,
    modifier: Modifier = Modifier
) {
    Crossfade(
        targetState = navType,
        modifier = modifier
    ) { navType ->
        when (navType) {
            NavType.HOME -> SpotifyHome()
            NavType.SEARCH -> SpotifySearchScreen()
            NavType.LIBRARY -> SpotifyLibrary()
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    SpotifyCloneTheme {
        SpotifyAppContent()
    }
}




