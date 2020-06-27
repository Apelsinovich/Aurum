package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class EventListFragment : Fragment() {
    private var arrayOfEvents: ArrayList<Event> = ArrayList()
    private var adapter: Adapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View? = inflater.inflate(R.layout.fragment_event_list, container, false)
        val eventRecyclerView: RecyclerView = v!!.findViewById(R.id.event_recycler_view)
        eventRecyclerView.layoutManager = LinearLayoutManager(activity)

        //Заменить на класс,в котором создастся список

        arrayOfEvents.add(Event("qwerty", "qwett", "qwerty"))
        arrayOfEvents.add(Event("qwerty222", "qwet222t", "qwerty22"))
        arrayOfEvents.add(Event("sdfsfsdfasf", "qafsfddsft", "asdfasdf"))
        arrayOfEvents.add(Event("qwertaaaaay222", "qwaaaat", "qasdf"))
        arrayOfEvents.add(Event("qwertdfdfdsfy222", "qasdf", "qasdfa"))
        adapter = Adapter(arrayOfEvents)
        eventRecyclerView.adapter = adapter
        return v
    }

    private class EventHolder(inflater: LayoutInflater, parent: ViewGroup?) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_event, parent, false))


    private class EventAdapter internal constructor(
        //private var context: Context,
        private var events: ArrayList<Event>
    ) :
        RecyclerView.Adapter<EventHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
            val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
            return EventHolder(layoutInflater, parent)
        }

        override fun getItemCount(): Int {
            //
            return events.size
        }

        override fun onBindViewHolder(holder: EventHolder, position: Int) {
            //
        }


    }
}

