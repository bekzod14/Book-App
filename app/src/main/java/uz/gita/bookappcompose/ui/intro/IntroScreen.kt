package uz.gita.bookappcompose.ui.intro

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import uz.gita.bookappcompose.R
import uz.gita.bookappcompose.data.models.IntroData
import uz.gita.bookappcompose.presenter.IntroScreenViewModelImpl

class IntroScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel: IntroScreenViewModel = getViewModel<IntroScreenViewModelImpl>()
        Surface(Modifier.fillMaxSize()) {
            TabLayout(viewModel::onEventDispatcher)
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun TabLayout(
        eventDispatcher: (Intent) -> Unit
    ) {
        val systemUiController: SystemUiController = rememberSystemUiController()
        systemUiController.isSystemBarsVisible = false//remove status bar
        val items = ArrayList<IntroData>()
        items.add(
            IntroData(
                "Title - 1",
                R.drawable.book1,
                "Reading is good for you because it improves your focus, memory, empathy, and communication skills.",
                Color.Red
            )
        )
        items.add(
            IntroData(
                "Title - 2",
                R.drawable.book2,
                "It can reduce stress, improve your mental health, and help you live longer.",
                Color.Yellow
            )
        )
        items.add(
            IntroData(
                "Title - 3",
                R.drawable.book3,
                "Reading also allows you to learn new things to help you succeed in your work and relationships."
            )
        )

        val pagerState =
            rememberPagerState(pageCount = items.size, initialOffscreenLimit = 2, initialPage = 0)

        OnBoardingPager(
            item = items,
            pagerState = pagerState,
            modifier = Modifier.fillMaxWidth(),
            eventDispatcher
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    item: List<IntroData>,
    pagerState: PagerState,
    modifier: Modifier,
    eventDispatcher: (Intent) -> Unit

) {
    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(item[page].backgroundColor)
                        .padding(50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = item[page].img), contentDescription = null,
                        modifier.fillMaxWidth()
                    )
                    Text(text = item[page].tittle, fontSize = 32.sp, fontWeight = FontWeight.Bold)
                    Text(text = item[page].content, fontSize = 20.sp, textAlign = TextAlign.Center)

                    if (page == 2) {
                        Button(
                            onClick = {
                                eventDispatcher.invoke(Intent.OpenMain)
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Text(text = "Next")
                        }
                    }
                }
            }
        }
    }
}