package com.ns.spotifyclone.data

import androidx.compose.ui.graphics.Color
import com.ns.spotifyclone.ui.theme.graySurface

object GradientDataProvider {

    fun spotifySurfaceGradient(isDark: Boolean) =
        if (isDark) listOf(graySurface, Color.Black) else listOf(Color.White, Color.LightGray)
}