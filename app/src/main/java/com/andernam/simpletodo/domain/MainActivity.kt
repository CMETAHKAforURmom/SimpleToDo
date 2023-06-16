@file:OptIn(ExperimentalMaterial3Api::class)

package com.andernam.simpletodo.domain

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import com.andernam.simpletodo.domain.CUSTOMauth
import com.andernam.simpletodo.presentation.MainScaffoldView
import com.andernam.simpletodo.ui.theme.SimpleToDoTheme
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    var USERfromFireBase: FirebaseUser? = null
    override fun onStart() {
        super.onStart()
        CUSTOMauth = Firebase.auth
        USERfromFireBase= CUSTOMauth.currentUser
    }


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
