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


        /*val event1 = findViewById<TextView>(R.id.Event1)
        event1.setText("Июнь, гп Северо-Енисейский, экологический квест Экобитва\nМесто проведение: МЦ Аурум")*/

        // data to populate the RecyclerView with

        // data to populate the RecyclerView with

        var arrayOfDates: ArrayList<String> = ArrayList()
        arrayOfDates = readData(arrayOfDates)
/*        val iS = assets.open("testText.csv")
        val sc = Scanner(iS, "cp1251")

        arrayOfDates.add(sc.nextLine())
        sc.close()*/

        // set up the RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.rvEvents)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter(this, arrayOfDates)
        adapter!!.setClickListener(this)
        recyclerView.adapter = adapter
        
    }
//для кнопки назад
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onItemClick(view: View?, position: Int) {
        Toast.makeText(
            this,
            "You clicked " + adapter!!.getItem(position) + " on row number " + position,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun readData(arrayOfData: ArrayList<String>):ArrayList<String> {
        //AssetManager am = activity.getAssets()
        val iS = assets.open("events.csv")
        val sc = Scanner(iS, "cp1251")
        //var line
        while (sc.hasNext()) {
            //var lines = sc.nextLine().split(";").toTypedArray()
            arrayOfData.add(sc.nextLine())
        }
        return arrayOfData
        //val strs = "name, 2012, 2017".split(",").toTypedArray()
    }

}
