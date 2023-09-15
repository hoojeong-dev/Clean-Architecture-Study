package com.example.compose.clean_architecture_study.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

/**
 * Navigation Destinations
 */
sealed class Destination(val route: String, val argument: String = "") {

    object Main: Destination("main")

    object Detail: Destination("detail", "url") {
        val routeWithArgument = "$route/{$argument}"
    }

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { append("/${it}") }
        }
    }

    fun getStringArgument(): List<NamedNavArgument> {
        return listOf(navArgument(argument) {
            type = NavType.StringType
        })
    }
}