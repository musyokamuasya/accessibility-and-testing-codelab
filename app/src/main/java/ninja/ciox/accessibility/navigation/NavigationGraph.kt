package ninja.ciox.accessibility.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ninja.ciox.accessibility.presentation.screens.HomeScreen
import ninja.ciox.accessibility.presentation.screens.SignUpScreen

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NavigationRoutes.SignUp.route) {
        composable(route = NavigationRoutes.SignUp.route) {
            SignUpScreen(onSignupButtonClicked = {
                navHostController.navigate(NavigationRoutes.HomeScreen.route)
            })
        }

        composable(route = NavigationRoutes.HomeScreen.route) {
            HomeScreen()
        }
    }
}