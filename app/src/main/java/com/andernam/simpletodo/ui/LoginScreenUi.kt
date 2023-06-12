package com.andernam.simpletodo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.andernam.simpletodo.ui.theme.Pink40
import com.andernam.simpletodo.ui.theme.Purple40

@Composable
fun LoginScreenUi(navController: NavController){
    Column(modifier = Modifier.fillMaxSize().background(Brush.linearGradient(listOf(Purple40, Pink40)))) {

        Text(text = "some Text")
    }
}

@Preview
@Composable
fun showEditElements(){

}