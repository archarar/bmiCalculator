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
        var measurements = DoubleArray(4)

        // get all widgets and results fragment
        val calculate : Button = view.findViewById(R.id.calculate)
        val heightft : EditText = view.findViewById(R.id.heightft)
        val heightin : EditText = view.findViewById(R.id.heightin)
        val neck : EditText = view.findViewById(R.id.neck)
        val waist : EditText = view.findViewById(R.id.waist)
        val errorMessage : TextView = view.findViewById(R.id.errorMessage)
        val resultsFrag = results()

        calculate.setOnClickListener {
            // make error message appear if there are any empty fields
            if(
                heightft.text.toString() == "" ||
                heightin.text.toString() == "" ||
                neck.text.toString() == "" ||
                waist.text.toString() == ""
            ) {
                errorMessage.visibility = android.view.View.VISIBLE
            }
            else {
                // turn all fields into doubles, add them to an array, and send the array to the results fragment
                measurements[0] = heightft.text.toString().toDouble()
                measurements[1] = heightin.text.toString().toDouble()
                measurements[2] = neck.text.toString().toDouble()
                measurements[3] = waist.text.toString().toDouble()
                bundle.putDoubleArray("data", measurements)
                resultsFrag.arguments = bundle
                fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer, resultsFrag)?.commit()
            }
        }

        return view
    }

}