package com.ph31058.lab7_ph31058.Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.ph31058.lab7_ph31058.LoginScreen
import com.ph31058.lab7_ph31058.Modal.Movie
import com.ph31058.lab7_ph31058.Modal.Screen
import com.ph31058.lab7_ph31058.MovieScreen2

@Composable
fun ScreenNavigation() {
   val navController = rememberNavController()
   
  NavHost(
     navController = navController,
     startDestination = Screen.LOGIN.route
  ) {
     composable(Screen.LOGIN.route){
        LoginScreen(navController = navController)
     }
     composable(Screen.MOVIE_SCREEN.route){
        MovieScreen2(movies = Movie.getSampleMovies() )
     }

      composable(Screen.SCREEN1.route){
         Screen1(navController = navController)
      }
     composable(Screen.SCREEN2.route){
        Screen2(navController = navController)
     }
     composable(Screen.SCREEN3.route){
        Screen3(navController = navController)

     }
  }
}

@Composable
fun Screen1(navController: NavController) {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .background(Color.Red)
         .clickable {
            navController.navigate(Screen.SCREEN2.route) {
               popUpTo(Screen.SCREEN1.route) { inclusive = true }
            }
         },
      contentAlignment = Alignment.Center
   ) {
      Text("Screen 1", color = Color.White, fontSize = 20.sp)
   }
}
@Composable
fun Screen2(navController: NavController) {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .background(Color.Yellow)
         .clickable { navController.navigate(Screen.SCREEN3.route) },
      contentAlignment = Alignment.Center
   ) {
      Text("Screen 2", color = Color.White, fontSize = 20.sp)
   }
}
@Composable
fun Screen3(navController: NavController) {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .background(Color.Green)
         .clickable { navController.navigate(Screen.SCREEN1.route) },
      contentAlignment = Alignment.Center
   ) {
      Text("Screen 3", color = Color.White, fontSize = 20.sp)
   }
}