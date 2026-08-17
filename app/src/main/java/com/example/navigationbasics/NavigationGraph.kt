package com.example.navigationbasics

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable(Screen.MainScreen.route) {

        }
    }
}