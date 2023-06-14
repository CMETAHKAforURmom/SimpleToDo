package com.andernam.simpletodo

import android.content.Context
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

sealed class CONST (val route: String){

    object LOGIN_SCREEN: CONST("Log in")
    object SIGIN_SCREEN: CONST("Sig in")
    object TODO_LISTS: CONST("Main list")
    object TODO_CURRENT: CONST("Main current")

}

lateinit var navController: NavController
lateinit var CUSTOMauth: FirebaseAuth

val PASS_ERROR_SYMBOL = "ERROR! PASS HAVE OTHER SYMBOLS"
val EMAIL_ERROR_SYMBOL = "ERROR! EMAIL HAVE OTHER SYMBOLS"
val PASS_ERROR_LENGTH = "ERROR! PASS MUST BE LONGER THAN 6 SYMBOLS"
val UNKNOWN_ERROR = "ERROR! SOMETHING WENT WRONG"
val EMPTY_FIELD = "ERROR! FIELD IS EMPTY"

val EMAIL_AND_PASS_CORRECT = "SUCCESSFUL!"