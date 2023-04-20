package com.example.bmicalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class results : Fragment() {

    private lateinit var mUsersViewModel : usersViewModel
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_results, container, false)
        val args = this.arguments
        val measurements = arguments?.getDoubleArray("data")

        val bmiView : TextView = view.findViewById(R.id.bmi)
        val tallest : TextView = view.findViewById(R.id.tallest)
        val shortest : TextView = view.findViewById(R.id.shortest)
        val averageBmi : TextView = view.findViewById(R.id.average)
        val back : Button = view.findViewById(R.id.back)
        val inputFrag = input()
        mUsersViewModel = ViewModelProvider(this)[usersViewModel::class.java]

        val heightft = measurements?.get(0)
        val heightin = measurements?.get(1)
        // total height in inches : (feet * 12) + inches
        val heightTotal = (heightft?.times(12))?.plus(heightin!!)
        val neck = measurements?.get(2)
        val waist = measurements?.get(3)

        // bmi calculation follows the formula: 86.01 x log10(waist - neck) - 70.041 x log10(height) + 36.76
        val bmi = 86.01 * kotlin.math.log10(waist?.minus(neck!!)!!) - 70.041 * kotlin.math.log10(heightTotal!!) + 36.76

        databaseInsert(
            heightft,
            heightin!!,
            heightTotal,
            neck!!,
            waist,
            bmi
        )
        mUsersViewModel.getTallest.observe(viewLifecycleOwner, Observer{ user ->
            val tallestft = user[0].heightft.toInt()
            val tallestin = user[0].heightin.toInt()

            tallest.text = "$tallestft ft  $tallestin in"
        })

        mUsersViewModel.getShortest.observe(viewLifecycleOwner, Observer{ user ->
            val shortestft = user[0].heightft.toInt()
            val shortestin = user[0].heightin.toInt()

            shortest.text = "$shortestft ft  $shortestin in"
        })

        mUsersViewModel.getAvgBmi.observe(viewLifecycleOwner, Observer{ user ->
            val avgBmi = user[0].bmi

            averageBmi.text = String.format("%.2f", avgBmi)
        })

        bmiView.text = String.format("%.2f", bmi)

        back.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer, inputFrag)?.commit()
        }

        return view
    }

    private fun databaseInsert(
        heightft : Double,
        heightin : Double,
        heightTotal : Double,
        neck : Double,
        waist : Double,
        bmi : Double
    ) {
        val user = user(heightft, heightin, heightTotal, neck, waist, bmi, 0)
        mUsersViewModel.insertUser(user)
    }

}
