package ninja.ciox.accessibility.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ninja.ciox.accessibility.presentation.screens.HomeScreen
import ninja.ciox.accessibility.presentation.screens.SignUpScreen

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NavDestinations.SignUp.route){
        composable(route = NavDestinations.SignUp.route){
            SignUpScreen(onSignButtonClicked = {
                navHostController.navigate(NavDestinations.Home.route)
            })
        }

        composable(route = NavDestinations.Home.route){
            HomeScreen()
        }
    }
}