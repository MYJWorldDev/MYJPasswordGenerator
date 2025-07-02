package com.yousufjamil.myjpasswordgenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yousufjamil.myjpasswordgenerator.data.DataSource.navController
import com.yousufjamil.myjpasswordgenerator.passwordGeneration.PasswordScreen
import com.yousufjamil.myjpasswordgenerator.ui.theme.MYJPasswordGeneratorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MYJPasswordGeneratorTheme {
                navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier
            .statusBarsPadding()
    ) {
        composable ("home") {
            HomeScreen()
        }

        composable ("password") {
            PasswordScreen()
        }
    }
}