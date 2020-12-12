package com.example.aurum_yc.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.aurum_yc.R
import com.example.aurum_yc.fragments.profile.LoginFragment

class LoginActivity: AppCompatActivity() {
    var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

/* Создание кнопки-стрелочки назад. Магия в купе с override fun onSupportNavigateUp()*/
        val actionBar = supportActionBar
        actionBar!!.title = "Назад"
        actionBar.setDisplayHomeAsUpEnabled(true)

        fragment = LoginFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(
            android.R.id.content,
            fragment as LoginFragment,
            "loginFragment"
        )
        fragmentTransaction.commit()

    }
    /* Функция с логикой для нажатия кнопки назад в верхнем toolbar е*/
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
