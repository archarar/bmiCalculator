package com.example.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class input : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)
        val bundle = Bundle()
        var measurements = DoubleArray(3)

        val calculate : Button = view.findViewById(R.id.calculate)
        val heightft : EditText = view.findViewById(R.id.heightft)
        val heightin : EditText = view.findViewById(R.id.heightin)
        val neck : EditText = view.findViewById(R.id.neck)
        val waist : EditText = view.findViewById(R.id.waist)
        val errorMessage : TextView = view.findViewById(R.id.errorMessage)
        val resultsFrag = results()

        calculate.setOnClickListener {
            if(
                heightft.text.toString() == "" ||
                heightin.text.toString() == "" ||
                neck.text.toString() == "" ||
                waist.text.toString() == ""
            ) {
                errorMessage.visibility = android.view.View.VISIBLE
            }
            else {
                measurements[0] = (heightft.text.toString().toDouble() * 12) + heightin.text.toString().toDouble()
                measurements[1] = neck.text.toString().toDouble()
                measurements[2] = waist.text.toString().toDouble()
                bundle.putDoubleArray("data", measurements)
                resultsFrag.arguments = bundle
                fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer, resultsFrag)?.commit()
            }
        }

        return view
    }

}