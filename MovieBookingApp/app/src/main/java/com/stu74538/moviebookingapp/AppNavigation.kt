package com.stu74538.moviebookingapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HomePage.route,
    ) {
        composable(route = Routes.HomePage.route)
        {
            HomePage(navController = navController)
        }
        composable( route = Routes.MoviePage.route + "/0" )
        {
            MoviePage(navController = navController, movieArray[0])
        }
        composable( route = Routes.MoviePage.route + "/1" )
        {
            MoviePage(navController = navController, movieArray[1])
        }
        composable( route = Routes.MoviePage.route + "/2" )
        {
            MoviePage(navController = navController, movieArray[2])
        }
        composable( route = Routes.MoviePage.route + "/3" )
        {
            MoviePage(navController = navController, movieArray[3])
        }
    }
}