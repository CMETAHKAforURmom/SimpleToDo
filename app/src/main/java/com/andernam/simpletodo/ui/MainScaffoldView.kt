package com.andernam.simpletodo.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.andernam.simpletodo.NavController
import com.andernam.simpletodo.ui.theme.Pink40
import com.andernam.simpletodo.ui.theme.Purple40

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffoldView(){
    Scaffold (modifier = Modifier){
        NavController()
    }
}