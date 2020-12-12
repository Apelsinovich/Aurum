package com.example.aurum_yc.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aurum_yc.fragments.events.EventActualListFragment
import com.example.aurum_yc.fragments.events.EventArchiveListFragment

class EventTabsPagerAdapter internal constructor (
    val fragment: Fragment,
    private val tabsCount: Int
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = tabsCount

    override fun createFragment(position: Int): Fragment{
        return if (position == 1) {
            EventArchiveListFragment()
        } else {
            EventActualListFragment()
        }
    }
}