package uz.gita.bookappcompose.ui.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import uz.gita.bookappcompose.R
import uz.gita.bookappcompose.data.models.IntroData
import uz.gita.bookappcompose.utils.BottomCardShape

class IntroScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        Surface(Modifier.fillMaxSize()) {
            TabLayout()
        }
    }

    @Preview
    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun TabLayout() {
        val systemUiController: SystemUiController = rememberSystemUiController()
        systemUiController.isSystemBarsVisible = false//remove status bar
        val items = ArrayList<IntroData>()
        items.add(IntroData("Title - 1", R.drawable.book1, "Content 1", Color.Red))
        items.add(IntroData("Title - 2", R.drawable.book2, "Content 2",Color.Yellow))
        items.add(IntroData("Title - 3", R.drawable.book3, "Content 3"))

        val pagerState =
            rememberPagerState(pageCount = items.size, initialOffscreenLimit = 2, initialPage = 0)

        OnBoardingPager(
            item = items,
            pagerState = pagerState,
            modifier = Modifier.fillMaxWidth()
        )


    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    item: List<IntroData>,
    pagerState: PagerState,
    modifier: Modifier
) {
    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(item[page].backgroundColor),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Image(painter = painterResource(id = item[page].img), contentDescription = null,
                    modifier.fillMaxWidth())
                }



            }
        }

        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .clip(BottomCardShape.large)
                    .height(340.dp)
            ) {
                Box() {
                    
                }
            }

        }
    }
}