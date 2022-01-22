package jp.kaleidot725.koinnavigationcompose.ui.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.kaleidot725.koinnavigationcompose.ui.screen.MainScreen
import jp.kaleidot725.koinnavigationcompose.ui.screen.MainViewModel
import jp.kaleidot725.koinnavigationcompose.ui.screen.SubScreen
import jp.kaleidot725.koinnavigationcompose.ui.screen.SubViewModel

@Composable
fun NavHostRelatedNone() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") {
            MainScreen(
                viewModel = MainViewModel(),
                onNext = {
                    navController.navigate("sub")
                }
            )
        }
        composable("sub") {
            SubScreen(
                viewModel = SubViewModel(),
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}