package com.example.myapplication.activities

import android.os.Bundle
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
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)


        val fm: FragmentManager = supportFragmentManager
        fragment = fm.findFragmentByTag("eventFragment")
        if (fragment == null) {
            val ft: FragmentTransaction = fm.beginTransaction()
            fragment = EventFragment()
            ft.add(android.R.id.content, fragment as EventFragment, "eventFragment")
            ft.commit()
        }

    }
}