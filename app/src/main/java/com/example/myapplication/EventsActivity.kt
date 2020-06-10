package com.example.myapplication

import android.os.Bundle

import android.view.MenuItem

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import java.util.*
import kotlin.collections.ArrayList


class EventsActivity : AppCompatActivity(){
    private var arrayOfEvents: ArrayList<Event> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        //кнопка назад
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        //массив событий событий
        arrayOfEvents = readData(arrayOfEvents)
        //вывод списком событий
        val recyclerView: RecyclerView = findViewById(R.id.rvEvents)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(arrayOfEvents)
        recyclerView.adapter = adapter

    }
    //событие для нажатия кнопки назад
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //функция считывания информации из файла и перенос в список
    private fun readData(arrayOfEvents: ArrayList<Event>):ArrayList<Event> {
        //AssetManager am = activity.getAssets()
        val iS = assets.open("events.csv")
        val sc = Scanner(iS, "cp1251")

        while (sc.hasNext()) {
            val lines = sc.nextLine().split(";").toTypedArray()

            arrayOfEvents.add(Event(caption = lines[0], info = lines[1], image = R.drawable.sword2, detailedInfo = lines[2]))
        }
        return arrayOfEvents
    }
}