package uz.gita.bookappcompose.navigator

import android.util.Log
import kotlinx.coroutines.flow.MutableSharedFlow
import uz.gita.bookappcompose.navigator.AppNavigator
import uz.gita.bookappcompose.navigator.AppScreen
import uz.gita.bookappcompose.navigator.NavigationArgs
import uz.gita.bookappcompose.navigator.NavigationHandler
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorDispatcher @Inject constructor() : AppNavigator, NavigationHandler {
    override val navigationStack = MutableSharedFlow<NavigationArgs>()

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