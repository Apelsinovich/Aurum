package com.example.aurum_yc.fragments.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.aurum_yc.R
import com.example.aurum_yc.activities.LoginActivity

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginCardView: CardView = view.findViewById(R.id.cardProfile)

        loginCardView.setOnClickListener{
            var registrationFormIntent = Intent(context, LoginActivity::class.java)
            requireContext().startActivity(registrationFormIntent)
        }
    }
}