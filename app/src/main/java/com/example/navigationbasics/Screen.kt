package com.example.navigationbasics

sealed class Screen(val route : String) {
    object MainScreen : Screen("MainScreen")
    object SecondScreen : Screen(route = "SecondScreen")
}