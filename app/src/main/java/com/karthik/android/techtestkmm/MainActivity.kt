package com.karthik.android.techtestkmm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.karthik.android.common.data.cache.dao.BookDao
import com.karthik.android.featurebooks.ui.BookListScreen
import dagger.hilt.android.AndroidEntryPoint
/**
 * KMM POC
 *
 * MainActivity class is entry point to
 * navigate to corresponding screens
 *
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            MyAppNavigation()
        }

    }
}

/**
 * Method to setup navigation
 *
 * nav path setup
 *
 */
@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "book_list") {
        composable("book_list") { BookListScreen(viewModel = hiltViewModel())
//        /*{ book ->
//            navController.navigate("book_details/${book.id}")
//        }*/
        }
    }
}