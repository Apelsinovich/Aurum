package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList


class EventsActivity : AppCompatActivity(), MyRecyclerViewAdapter.ItemClickListener {
    private var adapter: MyRecyclerViewAdapter? = null
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
        adapter = MyRecyclerViewAdapter(this, arrayOfEvents)
        adapter!!.setClickListener(this)
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
    //событие для нажатия на содержимое recycler - новость
    override fun onItemClick(view: View?, position: Int) {
        Toast.makeText(
            this,
            "You clicked " + adapter!!.getItem(position) + " on row number " + position,
            Toast.LENGTH_SHORT
        ).show()
    }
    //функция считывания информации из файла и перенос в список
    private fun readData(arrayOfEvents: ArrayList<Event>):ArrayList<Event> {
        //AssetManager am = activity.getAssets()
        val iS = assets.open("events.csv")
        val sc = Scanner(iS, "cp1251")

        while (sc.hasNext()) {
            var lines1 = sc.nextLine().split(";").toTypedArray()
            //var lines2= lines1.get(0)
            //var lines3= lines1.get(1)
            //var lines4= lines1.get(2)
            //println("GOGO " + lines2)
            //println("GOGO " + lines3)
            //println("GOGO " + lines4)
           //var lines = sc.nextLine()

            arrayOfEvents.add(Event(lines1[0], lines1[1], R.drawable.date))
            //var event :Event(lines[0] lines[1], lines[2])

            //var event: Event()
            //event = Event(lines[0], lines[1], lines[2])
           // arrayOfEvents.add()

        }

        return arrayOfEvents
    }

}
