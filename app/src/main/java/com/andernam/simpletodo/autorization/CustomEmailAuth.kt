package com.andernam.simpletodo.autorization

import android.content.Context
import android.util.Log
import androidx.compose.runtime.rememberCoroutineScope
import com.andernam.simpletodo.CUSTOMauth
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

class CustomEmailAuth {
    fun makeNewUser(email: String, pass: String) = CUSTOMauth.createUserWithEmailAndPassword(email, pass)

    fun loginUser(email: String, pass: String) = CUSTOMauth.signInWithEmailAndPassword(email, pass)
}