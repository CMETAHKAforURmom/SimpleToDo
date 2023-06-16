package com.andernam.simpletodo.autorization

import com.andernam.simpletodo.domain.CUSTOMauth

class CustomEmailAuth {
    fun makeNewUser(email: String, pass: String) = CUSTOMauth.createUserWithEmailAndPassword(email, pass)

    fun loginUser(email: String, pass: String) = CUSTOMauth.signInWithEmailAndPassword(email, pass)
}