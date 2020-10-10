package com.example.myapplication.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.R
import com.example.myapplication.ui.fragments.EventFragment


class EventActivity: AppCompatActivity(){

    var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        //supportActionBar?.hide()
//TODO подумать над заменой на toolBar и как вернукться назад в активити + как листать фрагменты
       val toolbar: Toolbar


        //магия в купе с override fun onSupportNavigateUp()
        val actionBar = supportActionBar
        actionBar!!.title = "Назад"
        actionBar.setDisplayHomeAsUpEnabled(true)

        //не работает (
        actionBar!!.setIcon(R.drawable.ic_home_active)








        val eventTitle= intent.extras!!.getString("eventTitle")
        val eventDetailInfo = intent.extras!!.getString("eventDetailInfo")
        val eventDate = intent.extras!!.getString("eventDate")
        val eventPlace = intent.extras!!.getString("eventPlace")


        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()


        val args = Bundle()
        args.putString("eventTitle", eventTitle)
        args.putString("eventDetailInfo", eventDetailInfo)
        args.putString("eventDate", eventDate)
        args.putString("eventPlace", eventPlace)

        fragment = EventFragment()
        (fragment as EventFragment).arguments = args

        fragmentTransaction.add(
            android.R.id.content,
            fragment as EventFragment,
                "eventFragment"
            )
            fragmentTransaction.commit()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

