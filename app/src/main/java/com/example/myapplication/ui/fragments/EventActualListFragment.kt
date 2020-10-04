package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.EventActualListFragmentAdapter
import com.example.myapplication.models.Event
import com.example.myapplication.models.EventFactory

class EventActualListFragment : Fragment() {

    private var arrayOfEvents: ArrayList<Event> = ArrayList()
    private lateinit var eventActualListFragmentAdapter: EventActualListFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View? = inflater.inflate(R.layout.fragment_event_actual_list, container, false)
        val eventRecyclerView: RecyclerView = v!!.findViewById(R.id.event_recycler_view)
        eventRecyclerView.layoutManager = LinearLayoutManager(activity)

        val eventFactory: EventFactory = EventFactory(context)
        val events: List<Event> = eventFactory.getEvents()
        // обработать что новостей нет, например инициализировать сразу пустым кард вью

        events.forEach{
            if (it.STATUS == "1") {
                arrayOfEvents.add(it)
            }
        }

        eventActualListFragmentAdapter = EventActualListFragmentAdapter(arrayOfEvents)
        eventRecyclerView.adapter = eventActualListFragmentAdapter
        return v
    }
}