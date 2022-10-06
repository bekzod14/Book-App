package uz.gita.composeexample2.navigator

import android.util.Log
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorDispatcher @Inject constructor() : AppNavigator, NavigationHandler {
    override val navigationStack = MutableSharedFlow<NavigationArgs>()

    init {
        Log.d("RRR","Nav Dispatcher Initialized")
    }
    private suspend fun navigate(arg: NavigationArgs) {
        navigationStack.emit(arg)
    }

    override suspend fun back() = navigate { pop() }
    override suspend fun backAll() = navigate { popAll() }
    override suspend fun backToRoot() = navigate { popUntilRoot() }
    override suspend fun navigateTo(screen: AppScreen) = navigate {
        Log.d("RRR", "Nav doing")
        push(screen)
    }
}