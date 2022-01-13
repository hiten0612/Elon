package com.example.elon.activities

import android.content.Context
import android.content.SharedPreferences

object Appreance {

    lateinit var preferences: SharedPreferences

    fun init(context: Context) {

        preferences = context.getSharedPreferences("Elon", Context.MODE_PRIVATE)

    }

    fun saveLogin(email: String, password: String) {
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()
    }

    fun setLogin(login: Boolean) {

        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putBoolean("LogIn", login)
        editor.apply()
    }

    fun getLogin(): Boolean {
        return preferences.getBoolean("LogIn", false)
    }

    fun getEmail(): String? {

        return preferences.getString("email", "")
    }

    fun getPassword(): String? {
        return preferences.getString("password", "")
    }

    fun clearData() {

        val email = getEmail()
        val password = getPassword()

        val editor: SharedPreferences.Editor = preferences.edit()
        editor.clear()
        editor.apply()
        saveLogin(email!!, password!!)

    }


}