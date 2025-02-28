package com.mas.authentication.screens.signup


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mas.authentication.R
import com.mas.authentication.components.CustomButton
import com.mas.authentication.components.CustomOutlineTextField
import com.mas.authentication.components.CustomClickableText
import com.mas.authentication.components.SubTitleText
import com.mas.authentication.components.TitleText
import com.mas.authentication.navigation.AuthScreen
import com.mas.authentication.ui.theme.PoppinsFamily
import com.mas.authentication.ui.theme.Gray100
import com.mas.authentication.ui.theme.Gray200
import com.mas.authentication.ui.theme.Gray400
import com.mas.authentication.ui.theme.Black900
import com.mas.authentication.ui.theme.customTypography


@Composable
fun SignUpScreen(navController: NavHostController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val isFormValid = fullName.isNotBlank() && email.isNotBlank() && password.isNotBlank()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(25.dp)
    ) {
        Column {

            TitleText(value ="Create an account")
            SubTitleText(value = "Let's create your account")


            CustomOutlineTextField(
                value = fullName,
                onValueChange = { fullName = it },
                textTitle = "Full Name",
                modifier = Modifier.padding(top = 20.dp),
                placeholder = "Enter your full name"
            )
            CustomOutlineTextField(
                value = email,
                onValueChange = { email = it },
                textTitle = "Email",
                modifier = Modifier.padding(top = 20.dp),
                placeholder = "Enter your email address"
            )
            CustomOutlineTextField(
                value = password,
                onValueChange = { password = it },
                textTitle = "Password",
                passwordIconEnabled = true,
                modifier = Modifier.padding(top = 20.dp),
                placeholder = "Enter your password"
            )

            //Terms and Conditions text
            CustomClickableText(modifier = Modifier.padding(top = 10.dp, start = 5.dp ))

            CustomButton(
                onClick = { /*TODO*/ }, buttonText = "Create Account", modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                enabled = isFormValid
            )

            //Divider
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(Gray100)
                )
                Text(
                    text = "Or",
                    style = customTypography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    color = Gray400,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(Gray100)
                )
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Gray200,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .fillMaxWidth()
                ,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(painter = painterResource(id = R.drawable.google_icon), contentDescription = null)
                Text(text = "Login with Google",
                    style = customTypography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = Black900,
                    modifier = Modifier.padding(10.dp))
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1877F2)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.facebook_icon), contentDescription = null)
                Text(text = "Login with Facebook",
                    style = customTypography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier.padding(10.dp))
            }
        }

        Row (modifier = Modifier.align(Alignment.BottomCenter)){
            val initialText = "Already have an account? "
            val join = "Log In"
            val annotatedString = buildAnnotatedString {
                withStyle(style = SpanStyle(fontFamily = PoppinsFamily, fontWeight = FontWeight.Normal, fontSize = 18.sp, color = Gray400)){
                    pushStringAnnotation(tag = initialText, annotation = initialText)
                    append(initialText)
                }

                withStyle(style = SpanStyle(fontFamily = PoppinsFamily, fontWeight = FontWeight.Normal, fontSize = 18.sp, color = Black900, textDecoration = TextDecoration.Underline)){
                    pushStringAnnotation(tag = join, annotation = join)
                    append(join)
                }

            }
            ClickableText(
                text = annotatedString,
                onClick = { offset ->
                    annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.let { span ->
                        if (span.item == join) navController.navigate(AuthScreen.Login.route)
                    }
                }
            )


        }
    }
}


@Preview
@Composable
fun SignUpScreenPreview() {
    val navController = rememberNavController()
    SignUpScreen(navController = navController)
}