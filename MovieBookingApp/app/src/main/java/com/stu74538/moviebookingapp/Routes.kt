package com.stu74538.moviebookingapp

sealed class Routes(val route: String) {
    data object HomePage : Routes("home_page")
    data object MoviePage : Routes("movie_page")
}