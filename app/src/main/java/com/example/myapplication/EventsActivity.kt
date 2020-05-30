package com.example.myapplication

import android.content.res.AssetManager
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.util.*
import kotlin.collections.ArrayList


class EventsActivity : AppCompatActivity(), MyRecyclerViewAdapter.ItemClickListener {
    private var adapter: MyRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        //кнопка назад
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        //массив событий событий
        var arrayOfEvents: ArrayList<String> = ArrayList()
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
    private fun readData(arrayOfEvents: ArrayList<String>):ArrayList<String> {
        //AssetManager am = activity.getAssets()
        val iS = assets.open("events.csv")
        val sc = Scanner(iS, "cp1251")

        while (sc.hasNext()) {
            //var lines = sc.nextLine().split(";").toTypedArray()
            arrayOfEvents.add(sc.nextLine())
        }

        return arrayOfEvents
    }

}
