package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class EventListActivity : AppCompatActivity() {
    //SingleFragmentActivity() {
/*    override fun createFragment(): Fragment {
        return EventListFragment()
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var selectedFragment: Fragment? = null
                when (item.itemId) {
                    R.id.bottom_home -> selectedFragment = HomeFragment()
                    R.id.bottom_events -> selectedFragment = EventListFragment()
                    R.id.bottom_contacts -> selectedFragment = ContactsFragment()
                }
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    selectedFragment!!
                ).commit()
                return true
            }
        }


}
