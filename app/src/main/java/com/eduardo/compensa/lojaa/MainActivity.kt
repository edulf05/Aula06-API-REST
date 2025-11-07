package com.eduardo.compensa.lojaa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eduardo.compensa.lojaa.ui.theme.LojaaTheme

class MainActivity : ComponentActivity() {
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LojaaTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "registration") {
                    composable("registration") {
                        RegistrationScreen(onRegister = {
                            userViewModel.addUser(it)
                            navController.navigate("userList")
                        })
                    }
                    composable("userList") {
                        val users by userViewModel.users.collectAsState()
                        UserListScreen(users = users)
                    }
                }
            }
        }
    }
}