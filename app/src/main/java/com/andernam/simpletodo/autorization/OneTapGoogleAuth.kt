package com.andernam.simpletodo.autorization

import android.provider.Settings.Global.getString
import com.andernam.simpletodo.R
import com.google.android.gms.auth.api.identity.BeginSignInRequest

class OneTapGoogleAuth {
    fun tryAuth(){
//        val signInRequest = BeginSignInRequest.builder()
//            .setGoogleIdTokenRequestOptions(
//                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
//                    .setSupported(true)
//                    // Your server's client ID, not your Android client ID.
//                    .setServerClientId(getString(R.string.client_id))
//                    // Only show accounts previously used to sign in.
//                    .setFilterByAuthorizedAccounts(true)
//                    .build())
//            .build()
    }

}