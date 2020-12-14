package com.example.aurum_yc.fragments.events

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aurum_yc.R
import com.example.aurum_yc.adapters.EventActualListFragmentAdapter
import com.example.aurum_yc.db.events.data.Event
import com.example.aurum_yc.db.events.data.EventDatabase
import com.example.aurum_yc.db.events.data.EventViewModel
import com.example.aurum_yc.models.events.EventFactory
import com.google.firebase.database.FirebaseDatabase


class EventActualListFragment : Fragment(){

    private var arrayOfEvents: ArrayList<Event> = ArrayList()
//    private lateinit var eventActualListFragmentAdapter: EventActualListFragmentAdapter
    private lateinit var mEventViewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View? = inflater.inflate(R.layout.fragment_event_actual_list, container, false)
        val eventRecyclerView: RecyclerView = v!!.findViewById(R.id.event_recycler_view)
        var eventActualListFragmentAdapter = EventActualListFragmentAdapter()


        eventRecyclerView.adapter = eventActualListFragmentAdapter
        eventRecyclerView.layoutManager = LinearLayoutManager(activity)

        val eventFactory = EventFactory(context)

       // var events: List<Event>? = eventFactory.getEvents()

        // ViewModel


        mEventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)
        mEventViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            eventActualListFragmentAdapter.setData(it)
        })



        // TODO обработать что новостей нет - написать сообщение
        // TODO вывести логику проверки на актуальность событий во внешний класс менеджер + проверить не создается ли лишний раз список событий

//        events?.forEach{
//            if (it.isActual) {
//                arrayOfEvents.add(it)
//
//                //TODO - для теста. Подумать, где работать с firebase
//                val database = FirebaseDatabase.getInstance("https://aurum-1fff3-default-rtdb.europe-west1.firebasedatabase.app/")
//                val myRef = database.getReference("actualEvents")
//                myRef.child("event" + it.UUID).setValue(it)
//            }
//        }
        //eventActualListFragmentAdapter = EventActualListFragmentAdapter(context, arrayOfEvents)

        return v
    }



}