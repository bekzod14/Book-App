package uz.gita.bookappcompose.app

import android.app.Application
import com.downloader.PRDownloader
import dagger.hilt.android.HiltAndroidApp
import uz.gita.bookappcompose.data.MySharedPreference

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        PRDownloader.initialize(this)
        MySharedPreference.init(this)
    }
}