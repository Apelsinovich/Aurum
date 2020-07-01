package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R

//ДЛЯ ЧЕГО?

class EventFragment: Fragment() {
/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Event(caption = "Event fragment number 1", info = "Information about event", detailedInfo = "lines[2]", expanded = false)
    }*/

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var v: View? = inflater.inflate(R.layout.fragment_event, container, false)
        return v
    }


}