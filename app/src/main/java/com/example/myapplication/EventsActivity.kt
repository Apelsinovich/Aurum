package com.example.myapplication

import android.graphics.drawable.Drawable
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

        //убрать верхний бар
        supportActionBar?.hide()
/*        //кнопка назад
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)*/

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
        val iS = assets.open("testText.csv")
        val sc = Scanner(iS, "cp1251")

        while (sc.hasNext()) {
            val lines = sc.nextLine().split(";").toTypedArray()
            println(lines[0])
            println(lines[1])
            println(lines[2])
            println(lines[3])
            arrayOfEvents.add(Event(caption = lines[0], info = lines[1], image = getDrawableFromAssets(lines[3]), detailedInfo = lines[2], expanded = false))
        }
        return arrayOfEvents
    }

    fun getDrawableFromAssets(path: String?): Drawable? {
        return Drawable.createFromStream(assets.open(path!!), null)
    }
}