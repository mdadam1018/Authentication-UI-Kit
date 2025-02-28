package com.mas.authentication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mas.authentication.R

val PoppinsFamily = FontFamily(
    Font(R.font.poppins_regular,FontWeight.Normal),
    Font(R.font.poppins_medium,FontWeight.Medium),
    Font(R.font.poppins_semibold,FontWeight.SemiBold),
    Font(R.font.poppins_bold,FontWeight.Bold)
)

val customTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 34.sp,
        letterSpacing = (-1).sp
    ),
    displayMedium = TextStyle(
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 40.sp
    ),
    displaySmall = TextStyle(
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp
    ),
    titleLarge = TextStyle(
        fontFamily = PoppinsFamily,
        fontSize = 24.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = PoppinsFamily,
        fontSize = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = PoppinsFamily,
        fontSize = 18.sp
    ),
    bodySmall = TextStyle(
        fontFamily = PoppinsFamily,
        fontSize = 20.sp
    )
)
