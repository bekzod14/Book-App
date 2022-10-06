package uz.gita.bookappcompose.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uz.gita.bookappcompose.data.MySharedPreference

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        MySharedPreference.init(this)
    }
}