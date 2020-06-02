package com.example.myapplication

import android.R.attr.button
import android.os.Build
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_row.*
import java.util.*
import kotlin.collections.ArrayList


class EventsActivity : AppCompatActivity(), MyRecyclerViewAdapter.ItemClickListener {
    private var adapter: MyRecyclerViewAdapter? = null
    private var arrayOfEvents: ArrayList<Event> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.KITKAT)
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
/*        expandBtn.setOnClickListener{
            if (expandEvent.visibility == View.GONE) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(cardEvent, AutoTransition())
                }
                expandEvent.visibility = View.VISIBLE
                expandBtn.text = "COLLAPSE"
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(cardEvent, AutoTransition())
                }
                expandEvent.visibility = View.GONE
                expandBtn.text = "EXPAND"
            }

        }*/
        if (expandEvent.visibility == View.GONE) {
            expandEvent.visibility = View.VISIBLE
        } else {
            expandEvent.visibility = View.GONE
        }

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

            arrayOfEvents.add(Event(lines1[0], lines1[1], R.drawable.date, lines1[1]))
        }
        return arrayOfEvents
    }
}
