package com.example.myapplication.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.ui.fragments.EventActualListFragment
import com.example.myapplication.ui.fragments.EventArchiveListFragment

class PagerAdapter internal constructor (
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