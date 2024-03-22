package ninja.ciox.accessibility.presentation.navigation

sealed class NavDestinations (val route: String){
    data object SignUp: NavDestinations(route = "signup")
    data object Home: NavDestinations(route = "home")
}