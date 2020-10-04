package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.EventArchiveListFragmentAdapter
import com.example.myapplication.models.Event
import com.example.myapplication.models.EventFactory
import kotlin.collections.ArrayList

class EventArchiveListFragment : Fragment() {

    private var arrayOfEvents: ArrayList<Event> = ArrayList()
    private lateinit var eventArchiveListFragmentAdapter: EventArchiveListFragmentAdapter

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
            //вынести реализацию проверки
        events.forEach{
            if (it.STATUS != "1") {
                arrayOfEvents.add(it)
            }
        }

        //Заменить на класс,в котором создастся список


        eventArchiveListFragmentAdapter = EventArchiveListFragmentAdapter(arrayOfEvents)
        eventRecyclerView.adapter = eventArchiveListFragmentAdapter
        return v
    }
}