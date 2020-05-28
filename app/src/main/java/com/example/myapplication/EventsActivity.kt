package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EventsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        val event1 = findViewById<TextView>(R.id.Event1)
        event1.setText("Июнь, гп Северо-Енисейский, экологический квест Экобитва\nМесто проведение: МЦ Аурум")



    }



}
