package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
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

        transferArgumentsToEventView(this, v)

        return v
    }

    override fun onPause() {

        super.onPause()

    }

    private fun transferArgumentsToEventView(fragment: EventFragment, view: View) {

        putArgumentsToEventView(view, getArgumentsFromBundle(fragment))

    }

    private fun getArgumentsFromBundle(fragment: EventFragment) : Array<String?> {

        val eventTitle = this.requireArguments().getString("eventTitle")
        val eventDetailInfo = this.requireArguments().getString("eventDetailInfo")
        val eventDate = this.requireArguments().getString("eventDate")
        val eventPlace = this.requireArguments().getString("eventPlace")

        return arrayOf(eventTitle, eventDetailInfo, eventDate, eventPlace)

    }

    private fun putArgumentsToEventView(view: View, array: Array<String?>) {

        view.tvEventTitle.text = array[0]
        view.tvEventDetailInfo.text = array[1]
        view.tvEventDate.text = array[2]
        view.tvEventPlace.text = array[3]

    }

}
