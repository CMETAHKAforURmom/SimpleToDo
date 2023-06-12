@file:OptIn(ExperimentalMaterial3Api::class)

package com.andernam.simpletodo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.andernam.simpletodo.ui.MainScaffoldView
import com.andernam.simpletodo.ui.theme.Pink40
import com.andernam.simpletodo.ui.theme.Purple40
import com.andernam.simpletodo.ui.theme.SimpleToDoTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isLogin = false
        lateinit var navController: NavController
        setContent {
            SimpleToDoTheme {
                MainScaffoldView()
            }
        }
    }

    fun authControl(){

    }
}
