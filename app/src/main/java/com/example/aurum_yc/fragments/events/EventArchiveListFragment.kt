package com.example.aurum_yc.fragments.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aurum_yc.R
import com.example.aurum_yc.adapters.EventArchiveListFragmentAdapter
import com.example.aurum_yc.db.events.data.Event
import com.example.aurum_yc.db.events.data.EventViewModel
import com.example.aurum_yc.models.events.EventFactory
import com.google.firebase.database.FirebaseDatabase
import kotlin.collections.ArrayList

class EventArchiveListFragment : Fragment() {

    private var arrayOfEvents: ArrayList<Event> = ArrayList()
//    private lateinit var eventArchiveListFragmentAdapter: EventArchiveListFragmentAdapter
    private lateinit var mEventViewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View? = inflater.inflate(R.layout.fragment_event_actual_list, container, false)
        val eventRecyclerView: RecyclerView = v!!.findViewById(R.id.event_recycler_view)
        var eventArchiveListFragmentAdapter = EventArchiveListFragmentAdapter()

        eventRecyclerView.adapter = eventArchiveListFragmentAdapter
        eventRecyclerView.layoutManager = LinearLayoutManager(activity)

        val database = FirebaseDatabase.getInstance("https://aurum-1fff3-default-rtdb.europe-west1.firebasedatabase.app/")
        val myRef = database.getReference("archiveEvents")

//        val eventFactory = EventFactory(context)
//        val events: List<Event> = eventFactory.getEvents()
        mEventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)
        mEventViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            it.forEach{
                if (it.DATE.toLong() < System.currentTimeMillis()) {
                    arrayOfEvents.add(it)
                    myRef.child("event" + it.UUID).setValue(it)
                }
            }
            eventArchiveListFragmentAdapter.setData(arrayOfEvents)
        })

        // TODO обработать что новостей нет, например инициализировать сразу пустым кард вью
        //TODO вывести логику проверки на актуальность событий во внешний класс менеджер + проверить не создается ли лишний раз список событий
//        events.forEach{
//            if (!it.isActual) {
//                arrayOfEvents.add(it)
//
//                //TODO - для теста. Подумать, где работать с firebase
//                val database = FirebaseDatabase.getInstance("https://aurum-1fff3-default-rtdb.europe-west1.firebasedatabase.app/")
//                val myRef = database.getReference("archieveEvents")
//                myRef.child("event" + it.UUID).setValue(it)
//            }
//        }
//        eventArchiveListFragmentAdapter = EventArchiveListFragmentAdapter(context, arrayOfEvents)
        return v
    }
}