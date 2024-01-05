package com.threemoly.sample

import android.app.Activity
import android.app.Application
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val systemBarColor = Color.TRANSPARENT
        //initKoin(AndroidApp.INSTANCE)
        //val root = RootComponent(componentContext = defaultComponentContext())
        setContent {
            val view = LocalView.current
            val isLightStatusBars by remember { mutableStateOf(false) }
            if (!view.isInEditMode) {
                LaunchedEffect(isLightStatusBars) {
                    val window = (view.context as Activity).window
                    WindowCompat.setDecorFitsSystemWindows(window, false)
                    window.statusBarColor = systemBarColor
                    window.navigationBarColor = systemBarColor
                    WindowCompat.getInsetsController(window, window.decorView).apply {
                        isAppearanceLightStatusBars = isLightStatusBars
                        isAppearanceLightNavigationBars = isLightStatusBars
                    }
                }
            }
            ExampleApp()
        }
    }
}