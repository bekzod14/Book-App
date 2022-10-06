package uz.gita.bookappcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import uz.gita.bookappcompose.ui.theme.BookAppTheme
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.bookappcompose.ui.splash.SplashScreen
import uz.gita.bookappcompose.ui.theme.BookAppComposeTheme
import uz.gita.composeexample2.navigator.NavigationHandler
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigationHandler: NavigationHandler

    @OptIn(ExperimentalAnimationApi::class)
    @SuppressLint("FlowOperatorInvokedInComposition", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            BookAppComposeTheme() {
                Navigator(screen = SplashScreen()) { navigator ->
                    navigationHandler.navigationStack
                        .onEach { it.invoke(navigator) }
                        .launchIn(lifecycleScope)
                    SlideTransition(navigator)
                }
            }
        }
    }
}
