package com.example.myapplication.activities

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.fragments.*
import com.example.myapplication.sql.EventBaseHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainMenuActivity : AppCompatActivity() {
    //SingleFragmentActivity() {
/*    override fun createFragment(): Fragment {
        return EventListFragment()
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //////

/*      val mContext: Context = baseContext
        val mDb: SQLiteDatabase

        mDb = EventBaseHelper(mContext).writableDatabase*/


        supportActionBar?.hide()

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_naviagtion)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

       if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                HomeFragment()
            ).commit()
        }
    }

    private val navListener: BottomNavigationView.OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.bottom_home -> selectedFragment =
                    HomeFragment()
                R.id.bottom_events -> selectedFragment =
                    //EventActualListFragment()
                    EventsTabsHolder()
                R.id.bottom_contacts -> selectedFragment =
                    ContactsFragment()
                R.id.bottom_menu -> selectedFragment =
                    MenuFragment()
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                selectedFragment!!
            ).commit()
            true
        }
}
