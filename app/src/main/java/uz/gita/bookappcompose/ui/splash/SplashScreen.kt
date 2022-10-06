package uz.gita.bookappcompose.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.bookappcompose.R
import uz.gita.bookappcompose.presenter.SplashViewModelImpl
import uz.gita.bookappcompose.ui.theme.BookAppTheme


class SplashScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel: SplashViewModel = getViewModel<SplashViewModelImpl>()
        SplashScreenContent()
    }
}

@Composable
private fun SplashScreenContent(

) {

    Column(
        modifier = Modifier
            .background(Color(0xFF7A4900))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.book_svgrepo_com),
            tint = Color.Unspecified, contentDescription = ""
        )
    }

}

@Composable
@Preview
private fun SplashScreenPreview() {
    BookAppTheme() {
        SplashScreenContent()
    }
}