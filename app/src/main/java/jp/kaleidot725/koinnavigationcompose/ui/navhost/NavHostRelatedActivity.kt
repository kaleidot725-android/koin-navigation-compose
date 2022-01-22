package jp.kaleidot725.koinnavigationcompose.ui.navhost

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.kaleidot725.koinnavigationcompose.ui.screen.MainScreen
import jp.kaleidot725.koinnavigationcompose.ui.screen.SubScreen
import org.koin.androidx.viewmodel.ext.android.getViewModel

@Composable
fun NavHostRelatedActivity(activity: Activity) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") {
            MainScreen(
                viewModel = activity.getViewModel(),
                onNext = {
                    navController.navigate("sub")
                }
            )
        }
        composable("sub") {
            SubScreen(
                viewModel = activity.getViewModel(),
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}