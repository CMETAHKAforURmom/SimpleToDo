package com.andernam.simpletodo.domain

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andernam.simpletodo.domain.CONST
import com.andernam.simpletodo.domain.navController
import com.andernam.simpletodo.presentation.LoginScreenUi
import com.andernam.simpletodo.presentation.SignScreen
import com.andernam.simpletodo.presentation.ToDoListsUserScreen

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
        composable(CONST.TODO_LISTS.route){
            ToDoListsUserScreen(navController)
        }
    }
}