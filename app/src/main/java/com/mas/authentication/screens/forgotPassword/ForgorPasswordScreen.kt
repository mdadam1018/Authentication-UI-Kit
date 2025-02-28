package com.mas.authentication.screens.forgotPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mas.authentication.components.CustomButton
import com.mas.authentication.components.CustomOutlineTextField
import com.mas.authentication.components.SubTitleText
import com.mas.authentication.components.TitleText


@Composable
fun ForgotPasswordScreen() {
    var email by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(25.dp)
    ) {
        Column {
            TitleText(value = "Forgot Password")
            SubTitleText(value = "Enter your email for the verification process. We will send password reset link to your email.")

            CustomOutlineTextField(
                value = email,
                onValueChange = { email = it },
                textTitle = "Email",
                modifier = Modifier.padding(top = 20.dp),
                placeholder = "Enter your email address"
            )

            //Reset Button
            CustomButton(
                onClick = { /*TODO*/ },
                buttonText = "Reset",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                enabled = email.isNotEmpty()
            )

        }
    }
}