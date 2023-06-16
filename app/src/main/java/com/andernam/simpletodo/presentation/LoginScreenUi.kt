package com.andernam.simpletodo.presentation

import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.andernam.simpletodo.domain.CONST
import com.andernam.simpletodo.domain.EMAIL_ERROR_SYMBOL
import com.andernam.simpletodo.domain.EMPTY_FIELD
import com.andernam.simpletodo.R
import com.andernam.simpletodo.autorization.CustomEmailAuth
import com.andernam.simpletodo.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenUi(navController: NavController){

    val passLimitMin = 6

    var tryClick by remember {
        mutableStateOf(false)
    }

    var findingAuthError by remember {
        mutableStateOf(EMPTY_FIELD)
    }

    var textEmail by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var textPass by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var isEmailError by remember {
        mutableStateOf(false)
    }
    var isPassError by remember {
        mutableStateOf(false)
    }

    val interactionSource = remember { MutableInteractionSource() }
    val passVisible by interactionSource.collectIsPressedAsState()

    Box (modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(text = stringResource(id = R.string.login), modifier = Modifier.align(Alignment.CenterHorizontally), style = Typography.bodyLarge)
            Spacer(modifier = Modifier.height(75.dp))
            TextField(
                value = textEmail,
                onValueChange = {
                    textEmail = it
                    if(isEmailError && isAllCorrect(textEmail.text, textPass.text) != EMAIL_ERROR_SYMBOL) isEmailError = false
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = if (!tryClick || !isEmailError) Color.DarkGray else Color.Red,
                    focusedIndicatorColor = Color.White,
                    cursorColor = Color.White
                ),
                placeholder = {
//                        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceAround){
                    Text(text = stringResource(id = R.string.your_email), style = Typography.labelSmall)},
//                        }

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
                    .height(50.dp)
                    .onFocusChanged {
                        if (it.isFocused && isAllCorrect(
                                textEmail.text,
                                textPass.text
                            ) == EMAIL_ERROR_SYMBOL
                        ) {
                            isEmailError = true
                            tryClick = true
                        }
                    },
                textStyle = Typography.labelSmall,

                )

            TextField(value = textPass,
                onValueChange = {
                    textPass = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = if (!isPassError) Color.DarkGray else Color.Red,
                    focusedIndicatorColor = Color.White,
                    cursorColor = Color.White
                ),
                placeholder = { Text(text = stringResource(id = R.string.your_pass), style = Typography.labelSmall)},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp, vertical = 10.dp)
                    .height(50.dp),
                textStyle = Typography.labelSmall,
                visualTransformation = if(passVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = {}, interactionSource = interactionSource) {
                        Icon(painter = painterResource(id = R.drawable.baseline_remove_red_eye_24), contentDescription = null)
                    }
                }
            )

            Button(
                onClick = {
                    CustomEmailAuth().loginUser(textEmail.text, textPass.text)
                        .addOnCompleteListener {
                            if(it.isSuccessful)navController.navigate(CONST.TODO_LISTS.route)
                            else Log.i("Login faild:", it.exception.toString())
                        }
                },
                shape = RoundedCornerShape(25.dp),
                enabled = !isPassError,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp, vertical = 10.dp)
                    .height(50.dp),
            ) {
                Text(text = stringResource(id = R.string.login))
            }

            Button(onClick = {
                navController.navigate(CONST.SIGIN_SCREEN.route)
            },
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp, vertical = 10.dp)
                    .height(50.dp),
            ) {
                Text(text = stringResource(id = R.string.new_acc))
            }

            Button(onClick = {navController.navigate(CONST.TODO_LISTS.route)}){
                Text(text = stringResource(id = R.string.counte_guest))
            }
        }
    }
}

@Composable
fun ButtonOnStart(ClickContext: () -> Unit, contentInside: @Composable RowScope.() -> Unit) = Button(onClick = {ClickContext},
    content = contentInside,
    shape = RoundedCornerShape(25.dp),
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 50.dp, vertical = 10.dp)
        .height(50.dp))
