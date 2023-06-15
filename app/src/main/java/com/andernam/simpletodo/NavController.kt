package com.andernam.simpletodo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andernam.simpletodo.ui.LoginScreenUi
import com.andernam.simpletodo.ui.SignScreen

@Composable
fun NavController(){
    val navigationController = rememberNavController()
    navController = navigationController
    NavHost(navController = navigationController, startDestination = CONST.LOGIN_SCREEN.route){
        composable(CONST.LOGIN_SCREEN.route){
            LoginScreenUi(navigationController)
        }
        composable(CONST.SIGIN_SCREEN.route){
            SignScreen(navController)
        }
    }

}