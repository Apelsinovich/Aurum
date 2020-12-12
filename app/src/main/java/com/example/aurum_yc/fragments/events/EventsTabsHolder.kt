package com.example.aurum_yc.fragments.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.aurum_yc.R
import com.example.aurum_yc.adapters.EventTabsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class EventsTabsHolder : Fragment() {

    private lateinit var eventsEventTabsHolderAdapter: EventTabsPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tab_event_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val tabTitels: Array<String> = arrayOf("Актуальные", "Прошедшие")

        eventsEventTabsHolderAdapter = EventTabsPagerAdapter(this, 2)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = eventsEventTabsHolderAdapter

        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitels[position]
            viewPager.setCurrentItem(tab.position, true)
        }.attach()
    }

}