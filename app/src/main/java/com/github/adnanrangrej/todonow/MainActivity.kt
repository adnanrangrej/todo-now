package com.github.adnanrangrej.todonow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.github.adnanrangrej.todonow.ui.TodoNowApp
import com.github.adnanrangrej.todonow.ui.theme.TodoNowTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoNowTheme {
                TodoNowApp()
            }
        }
    }
}

