package uz.gita.bookappcompose

import android.app.Application
import com.downloader.PRDownloader
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        PRDownloader.initialize(this)
    }

}