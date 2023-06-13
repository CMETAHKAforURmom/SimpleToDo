package com.andernam.simpletodo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.andernam.simpletodo.R
import com.andernam.simpletodo.ui.theme.Transparent
import com.andernam.simpletodo.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignScreen(navController: NavController){

    var textEmail by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var textPass by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                listOf(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.secondary
                )
            )
        )) {
            Column(modifier = Modifier.align(Alignment.Center)) {
                Text(text = stringResource(id = R.string.sign), modifier = Modifier.align(Alignment.CenterHorizontally), style = Typography.bodyLarge)
                Spacer(modifier = Modifier.height(75.dp))
                TextField(value = textEmail,
                    onValueChange = {
                        textEmail = it
                    },
                    placeholder = { Text(text = stringResource(id = R.string.your_email), style = Typography.labelSmall)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp).height(50.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Transparent,
                        focusedIndicatorColor = Transparent),
                    textStyle = Typography.labelSmall,
                    
                )

                TextField(value = textPass,
                    onValueChange = {
                        textPass = it
                    },
                    placeholder = { Text(text = stringResource(id = R.string.your_pass), style = Typography.labelSmall)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp, vertical = 10.dp).height(50.dp),
                    textStyle = Typography.labelSmall,

                    )
            }
    }
}