package com.example.navigationbasics.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationbasics.Greeting
import com.example.navigationbasics.Screen
import com.example.navigationbasics.SecondScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost( navController = navController, startDestination = Screen.MainScreen.route){
        composable("MainScreen"){
            Greeting(navController)

        }

        composable(
            route = "SecondScreen/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Ravi"
                    nullable = false
                }
            )){

            SecondScreen(navController, it.arguments?.getString("name")?: "" )
        }

    }
}