package com.example.compose.clean_architecture_study.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.clean_architecture_study.base.BaseActivity
import com.example.compose.clean_architecture_study.ui.detail.DetailScreen
import com.example.compose.clean_architecture_study.ui.main.MainScreen
import com.example.compose.clean_architecture_study.ui.theme.CleanArchitectureStudyTheme
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@AndroidEntryPoint
class Navigation : BaseActivity() {

    @Composable
    override fun BuildContent() {
        NavHost()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavHost() {

    CleanArchitectureStudyTheme {

        val navController = rememberNavController()

        Scaffold { innerPadding ->

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFF8F8F8)
            ) {

                NavHost(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController,
                    startDestination = Destination.Main.route
                ) {

                    composable(route = Destination.Main.route) {
                        MainScreen(
                            moveToDetail = { url ->

                                val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
                                navController.navigate(Destination.Detail.withArgs(encodedUrl))
                            }
                        )
                    }

                    composable(
                        route = Destination.Detail.routeWithArgument,
                        arguments = Destination.Detail.getStringArgument()
                    ) { backStackEntry ->

                        val url = backStackEntry.arguments?.getString(Destination.Detail.argument)?: ""
                        DetailScreen(url)
                    }
                }
            }
        }
    }
}