package com.mas.authentication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import androidx.navigation.compose.composable
import com.mas.authentication.screens.forgotPassword.ForgotPasswordScreen
import com.mas.authentication.screens.login.LoginScreen
import com.mas.authentication.screens.signup.SignUpScreen


const val authRoute = "auth"

sealed class AuthScreen(val route: String) {
    data object Login : AuthScreen("login")
    data object SignUp : AuthScreen("signup")
    data object ForgotPassword : AuthScreen("forgotPassword")
}

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {

    navigation(
        startDestination = AuthScreen.Login.route,
        route = authRoute
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = AuthScreen.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = AuthScreen.ForgotPassword.route) {
            ForgotPasswordScreen()
        }
    }

}
