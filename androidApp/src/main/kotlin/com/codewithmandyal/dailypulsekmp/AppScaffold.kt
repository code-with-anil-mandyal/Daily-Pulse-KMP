package com.codewithmandyal.dailypulsekmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codewithmandyal.dailypulsekmp.screens.AboutScreen
import com.codewithmandyal.dailypulsekmp.screens.ArticlesScreen
import com.codewithmandyal.dailypulsekmp.screens.Screens

@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }

}

@Composable
fun AppNavHost(
    navController : NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier
    ){
        composable(Screens.ARTICLES.route){
            ArticlesScreen(
                onAboutButtonClick = {
                    navController.navigate(Screens.ABOUT_DEVICES.route)
                }
            )
        }

        composable(Screens.ABOUT_DEVICES.route){
            AboutScreen(
                onUpButtonClick = {
                    navController.popBackStack()
                }
            )
        }
        }
    }
    
