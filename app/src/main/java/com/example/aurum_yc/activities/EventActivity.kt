package com.example.aurum_yc.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.aurum_yc.R
import com.example.aurum_yc.fragments.events.EventFragment

/* Класс для отдельного представления события Event окном*/

class EventActivity: AppCompatActivity(){

    var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

/* Создание кнопки-стрелочки назад. Магия в купе с override fun onSupportNavigateUp()*/
        val actionBar = supportActionBar
        actionBar!!.title = "Назад"
        actionBar.setDisplayHomeAsUpEnabled(true)

        //todo - разобраться почему не работает
        actionBar!!.setIcon(R.drawable.ic_home_active)

/* Логика получения данных (аргументов) переданных из адаптера EventActualListFragmentAdapter*/

        val eventTitle = intent.extras!!.getString("eventTitle")
        val eventDetailInfo = intent.extras!!.getString("eventDetailInfo")
        val eventDate = intent.extras!!.getString("eventDate")
        val eventPlace = intent.extras!!.getString("eventPlace")

/* Логика по созданию, удерживанию фрагмента в активти + передача полученных данных выше в фрагмент*/

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val argumentsForEventFragment = Bundle()
        argumentsForEventFragment.putString("eventTitle", eventTitle)
        argumentsForEventFragment.putString("eventDetailInfo", eventDetailInfo)
        argumentsForEventFragment.putString("eventDate", eventDate)
        argumentsForEventFragment.putString("eventPlace", eventPlace)

        fragment = EventFragment()
        (fragment as EventFragment).arguments = argumentsForEventFragment

        fragmentTransaction.add(
            android.R.id.content,
            fragment as EventFragment,
                "eventFragment"
            )
            fragmentTransaction.commit()

    }
/* Функция с логикой для нажатия кнопки назад в верхнем toolbar е*/
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

