package com.andernam.simpletodo.autorization

import android.util.Log
import com.andernam.simpletodo.CUSTOMauth
import com.google.android.gms.tasks.OnCompleteListener

class CustomEmailAuth {
    fun makeNewUser(email: String, pass: String){
        CUSTOMauth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(OnCompleteListener {
//            if(it.isSuccessful)
//                Log.i("Login successful", it.isSuccessful.toString())
        })
    }

}