package com.example.aurum_yc.fragments.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.aurum_yc.R
import com.example.aurum_yc.activities.LoginActivity
import com.google.firebase.auth.FirebaseAuth

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
        val loginCardView: CardView = view.findViewById(R.id.cardGuest)
        val cvGuest: CardView = view.findViewById(R.id.cardGuest)
        val cvAdmin: CardView = view.findViewById(R.id.cardSignedAdmin)
        val btLogout: Button = view.findViewById(R.id.bt_logout)
        val auth = FirebaseAuth.getInstance()

        loginCardView.setOnClickListener{
            var registrationFormIntent = Intent(context, LoginActivity::class.java)
            requireContext().startActivity(registrationFormIntent)
        }



        btLogout.setOnClickListener {
            auth.signOut()
            cvGuest.visibility = View.VISIBLE
            cvAdmin.visibility = View.GONE
            btLogout.visibility = View.GONE
        }

        if (auth.currentUser?.email.equals("ignatcovidov@gmail.com")) {
            btLogout.visibility = View.VISIBLE
            cvGuest.visibility = View.GONE
            cvAdmin.visibility = View.VISIBLE
        } else {
            btLogout.visibility = View.GONE
            cvGuest.visibility = View.VISIBLE
            cvAdmin.visibility = View.GONE
        }

    }
}