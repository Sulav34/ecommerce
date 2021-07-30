package com.example.ecommercesiteforonlineshopping.fragments

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.ecommercesiteforonlineshopping.R
import com.example.ecommercesiteforonlineshopping.ui.*


class AboutFragment : Fragment(R.layout.fragment_about) {
    private lateinit var about: TextView
    private lateinit var btnLogout: Button
    private lateinit var maplocation:TextView
    private lateinit var feedbacks:TextView
    private lateinit var theme: TextView
    private lateinit var sensor:TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        about = view.findViewById(R.id.about)
        maplocation = view.findViewById(R.id.maplocation)
        feedbacks = view.findViewById(R.id.feedbacks)
        theme = view.findViewById(R.id.theme)
        sensor = view!!.findViewById(R.id.sensor)
        btnLogout = view!!.findViewById(R.id.btnLogout)




        btnLogout.setOnClickListener {
            val sharedPref = requireActivity().getSharedPreferences("MY_PREFERENCES", Activity.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPref.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }

        about.setOnClickListener {
            val intent = Intent(activity, AboutActivity::class.java)
            startActivity(intent);
        }
        maplocation.setOnClickListener{
            val intent = Intent(activity, ViewMapsActivity::class.java)
            startActivity(intent)
        }
        feedbacks.setOnClickListener{
            val intent = Intent(activity, FeedbackActivity::class.java)
            startActivity(intent)
        }

        theme.setOnClickListener{
            val intent = Intent(activity, ThemeActivity::class.java)
            startActivity(intent)
        }

        sensor.setOnClickListener{
            val intent = Intent(activity, SensorActivity::class.java)
            startActivity(intent)
        }






        return view
    }
}
