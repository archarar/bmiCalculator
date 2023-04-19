package com.example.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.lang.Math.log10
import java.text.DecimalFormat

class results : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_results, container, false)
        val args = this.arguments
        val measurements = arguments?.getDoubleArray("data")

        val bmiView : TextView = view.findViewById(R.id.bmi)
        val back : Button = view.findViewById(R.id.back)
        val inputFrag = input()

        val height = measurements?.get(0)
        val neck = measurements?.get(1)
        val waist = measurements?.get(2)

        // bmi calculation follows the formula: 86.01 x log10(waist - neck) - 70.041 x log10(height) + 36.76
        val bmi = 86.01 * kotlin.math.log10(waist?.minus(neck!!)!!) - 70.041 * kotlin.math.log10(height!!) + 36.76

        bmiView.text = String.format("%.2f", bmi)

        back.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer, inputFrag)?.commit()
        }

        return view
    }

}
