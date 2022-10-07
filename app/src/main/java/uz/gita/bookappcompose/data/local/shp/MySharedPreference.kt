package uz.gita.bookappcompose.data.local.shp

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Singleton

@Singleton
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

    fun setIsFirst(isFirst: Boolean) {
        editor.putBoolean("is_first", isFirst).apply()
    }

    fun getIsFirst(): Boolean =
        sharedPreferences.getBoolean("is_first", true)
}
