package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.activities.EventActivity
import kotlinx.android.synthetic.main.fragment_event.*
import kotlinx.android.synthetic.main.fragment_event.view.*
import kotlinx.android.synthetic.main.fragment_event.view.tvEventDate
import kotlinx.android.synthetic.main.fragment_event.view.tvEventPlace
import kotlinx.android.synthetic.main.fragment_event.view.tvEventTitle
import kotlinx.android.synthetic.main.fragment_event_details.view.*

class EventFragment: Fragment() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val v = inflater.inflate(R.layout.fragment_event_details, container, false)

        val eventTitle = this.requireArguments().getString("eventTitle")
        val eventDetailInfo = this.requireArguments().getString("eventDetailInfo")
        val eventDate = this.requireArguments().getString("eventDate")
        val eventPlace = this.requireArguments().getString("eventPlace")


        v.tvEventTitle.text = eventTitle
        v.tvEventDetailInfo.text = eventDetailInfo
        v.tvEventDate.text = eventDate
        v.tvEventPlace.text = eventPlace



        return v
    }

    override fun onPause() {
        super.onPause()

    }
}
