package com.andernam.simpletodo

import androidx.navigation.NavController

sealed class CONST (val route: String){

    object LOGIN_SCREEN: CONST("Log in")
    object SIGIN_SCREEN: CONST("Sig in")
    object TODO_LISTS: CONST("Main list")
    object TODO_CURRENT: CONST("Main current")

}

lateinit var navController: NavController