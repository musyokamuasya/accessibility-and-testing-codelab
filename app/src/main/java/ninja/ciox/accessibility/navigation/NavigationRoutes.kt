package ninja.ciox.accessibility.navigation

sealed class NavigationRoutes(val route: String) {
    data object SignUp : NavigationRoutes(route = "register")
    data object HomeScreen : NavigationRoutes(route = "homescreen")
}