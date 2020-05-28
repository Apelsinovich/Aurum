package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({
            //.setProgressTintList(ColorStateList.valueOf(Color.red);
            startActivity(Intent(this, MainActivity::class.java))
            //sleep(5000)
            finish()
        }, SPLASH_TIME_OUT)
    }
}
