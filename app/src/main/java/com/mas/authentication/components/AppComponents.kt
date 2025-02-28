package com.mas.authentication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mas.authentication.R
import com.mas.authentication.ui.theme.Error
import com.mas.authentication.ui.theme.PoppinsFamily
import com.mas.authentication.ui.theme.Gray100
import com.mas.authentication.ui.theme.Gray200
import com.mas.authentication.ui.theme.Gray300
import com.mas.authentication.ui.theme.Gray400
import com.mas.authentication.ui.theme.Black900
import com.mas.authentication.ui.theme.Success
import com.mas.authentication.ui.theme.customTypography


@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonText: String? = "",
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Black900,
            disabledContainerColor = Gray200
        ),
        border = border,
        contentPadding = contentPadding,
    ) {
        Text(
            text = "$buttonText",
            modifier = Modifier.padding(vertical = 5.dp),
            style = customTypography.bodyLarge,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}


@Composable
fun CustomOutlineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: @Composable (() -> Unit)? = null,
    placeholder: String? = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    passwordIconEnabled: Boolean = false,
    prefix: @Composable (() -> Unit)? = null,
    supportingText: String? = "",
    supportingTextColor: Color = Error,
    isError: Boolean = false,
    isSuccess: Boolean = false,
    textTitle: String? = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
) {
    val isPasswordVisible = remember { mutableStateOf(false) }

    val visualTransformationState = if (passwordIconEnabled && !isPasswordVisible.value) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }

    Column(modifier = modifier) {
        if (!textTitle.isNullOrEmpty()) {
            Text(
                text = "$textTitle",
                style = customTypography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = Black900,
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            enabled = enabled,
            readOnly = readOnly,
            textStyle = TextStyle(
                fontFamily = PoppinsFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Black900
            ),
            label = label,
            placeholder = {
                Text(
                    text = "$placeholder",
                    style = customTypography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    color = Gray300
                )
            },
            leadingIcon = leadingIcon,
            trailingIcon = {

                if (passwordIconEnabled) {
                    IconButton(
                        onClick = { isPasswordVisible.value = !isPasswordVisible.value },
                    ) {
                        if (isPasswordVisible.value) {
                            Icon(
                                painter = painterResource(R.drawable.eye_on),
                                contentDescription = "Toggle password visibility",
                                tint = Black900
                            )
                        } else {
                            Icon(
                                painter = painterResource(R.drawable.eye_off),
                                contentDescription = "Toggle password visibility",
                                tint = Gray100
                            )
                        }

                    }
                } else if (isError) {
                    Icon(
                        painter = painterResource(id = R.drawable.warning_circle),
                        contentDescription = null,
                        tint = Error
                    )
                } else if (isSuccess) {
                    Icon(
                        painter = painterResource(id = R.drawable.success_circle),
                        contentDescription = null,
                        tint = Success
                    )
                } else {
                    trailingIcon?.invoke()
                }
            },
            prefix = prefix,
            visualTransformation = visualTransformationState,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            maxLines = maxLines,
            minLines = minLines,
            shape = RoundedCornerShape(10.dp),
            colors = if (isError) OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Error,
                focusedBorderColor = Error
            )
            else if (isSuccess) OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Success,
                focusedBorderColor = Success
            )
            else OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Gray100,
                focusedBorderColor = Gray400
            )
        )

        //Supporting Text
        Spacer(modifier = Modifier.height(3.dp))

        if (!supportingText.isNullOrEmpty()) {
            Text(
                text = "$supportingText",
                style = customTypography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = supportingTextColor
            )
        }

    }

}

@Preview
@Composable
fun CustomOutlineTextfieldPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CustomOutlineTextField(
            value = "",
            onValueChange = { },
            textTitle = "Email",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
    }

}


@Composable
fun TitleText(value: String) {
    Text(
        text = value,
        color = Black900,
        style = customTypography.displayLarge
    )
}

@Composable
fun SubTitleText(value: String) {
    Text(
        text = value,
        color = Gray400,
        style = customTypography.bodyLarge,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun CustomClickableText(modifier: Modifier = Modifier) {
    val initialText = "By signing up you agree to our "
    val termText = "Terms,"
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val cookieText = "Cookie Use"

    val normalStyle = SpanStyle(
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Gray400
    )
    val underlineStyle = SpanStyle(
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Black900,
        textDecoration = TextDecoration.Underline
    )

    val annotatedString = buildAnnotatedString {
        withStyle(style = normalStyle) {
            pushStringAnnotation(tag = initialText, annotation = initialText)
            append(initialText)
        }

        withStyle(style = underlineStyle) {
            pushStringAnnotation(tag = termText, annotation = termText)
            append(termText)
        }
        append(" ")
        withStyle(style = underlineStyle) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        withStyle(style = normalStyle) {
            pushStringAnnotation(tag = andText, annotation = andText)
            append(andText)
        }
        withStyle(style = underlineStyle) {
            pushStringAnnotation(tag = cookieText, annotation = cookieText)
            append(cookieText)
        }

    }
    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    if (span.item == termText) {
                        //TODO
                    } else {
                        //TODO
                    }
                }

        },
        modifier = modifier,
    )
}