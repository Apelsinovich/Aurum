package com.example.aurum_yc.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.aurum_yc.MainMenuActivity
import com.example.aurum_yc.R

// todo - Проработть сплеш скрин тщательно, почитать про это. Что с производительностью?

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, MainMenuActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}
