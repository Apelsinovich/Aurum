package com.example.aurum_yc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aurum_yc.R
import com.example.aurum_yc.fragments.MenuFragment
import com.example.aurum_yc.fragments.clubs.ClubListFragment
import com.example.aurum_yc.fragments.events.EventsTabsHolder
import com.example.aurum_yc.fragments.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.FirebaseDatabase


class MainMenuActivity : AppCompatActivity() {
    //SingleFragmentActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*      val mContext: Context = baseContext
        val mDb: SQLiteDatabase

        mDb = EventBaseHelper(mContext).writableDatabase*/

//        val database = FirebaseDatabase.getInstance("https://aurum-1fff3-default-rtdb.europe-west1.firebasedatabase.app/")
//        val myRef = database.getReference("TEST")
//        myRef.setValue("Hello, World!")

        supportActionBar?.hide()

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_naviagtion)
        bottomNav.setOnNavigationItemSelectedListener(navListener)


// todo - решить вопрос с отображением фрагмента по умолчанию (решено) + корректного активного элемента меню
       if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                MenuFragment()

            ).commit()
        }
    }
// todo - вопрос века, как стартвоать детализированную карточку События, Секции, Логина без создания новой активности, а использова MainMenuActivity
    private val navListener: BottomNavigationView.OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.bottom_clubs -> selectedFragment =
                    ClubListFragment()
                R.id.bottom_events -> selectedFragment =
                    EventsTabsHolder()
                R.id.bottom_profile -> selectedFragment =
                    ProfileFragment()

//                R.id.bottom_contacts -> selectedFragment =
//                    ContactsFragment()
                R.id.bottom_menu -> selectedFragment =
                    MenuFragment()
//                R.id.bottom_weather -> selectedFragment =
//                    WeatherFragment()
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                selectedFragment!!
            ).commit()
            true
        }
}