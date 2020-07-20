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

        //Заменить на класс,в котором создастся список

        arrayOfEvents.add(
            Event(
                1,
                "АРХИВНОЕ СОБЫТИЕ НОМЕР 1",
                "8 июня - 20 июня",
                "Отличное событие и подарки хорошие"
            )
        )
        arrayOfEvents.add(
            Event(
                2,
                "АРХИВНОЕ СОБЫТИЕ 2",
                "1 июля",
                "Приходите, будет весело"
            )
        )
        arrayOfEvents.add(
            Event(
                3,
                "АРХИВНОЕ СОБЫТИЕ 3",
                "21 июля",
                "День рождения, 30 лет как ни крути"
            )
        )
        arrayOfEvents.add(
            Event(
                4,
                "АРХИВНОЕ СОБЫТИЕ 4",
                "16 августа",
                "qОсень, скоро осень"
            )
        )
        arrayOfEvents.add(
            Event(
                5,
                "АРХИВНОЕ СОБЫТИЕ 5",
                "qasdf",
                "qasdfa"
            )
        )
        eventArchiveListFragmentAdapter = EventArchiveListFragmentAdapter(arrayOfEvents)
        eventRecyclerView.adapter = eventArchiveListFragmentAdapter
        return v
    }
}