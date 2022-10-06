package uz.gita.bookappcompose.data

import android.content.Context
import android.content.SharedPreferences


class MySharedPreference private constructor(context: Context) {
    init {
        sharedPreferences = context.getSharedPreferences("app_name", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }


    companion object {

        private var mysSharedPreference: MySharedPreference? = null
        private lateinit var sharedPreferences: SharedPreferences
        private lateinit var editor: SharedPreferences.Editor

        fun init(context: Context): MySharedPreference? {
            if (mysSharedPreference == null) {
                mysSharedPreference = MySharedPreference(context)
            }
            return mysSharedPreference
        }

        fun getInstance() = mysSharedPreference!!
    }

    fun setOpenScreen(screenName: String) {
        editor.putString("screen_name", screenName).apply()
    }

    fun getOpenScreen(): String =
        sharedPreferences.getString("screen_name", "Intro Screen").toString()
}
