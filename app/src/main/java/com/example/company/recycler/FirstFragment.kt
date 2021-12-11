package com.example.company.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.company.R

class firstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_first, container, false)
         val button =view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val editText =view.findViewById<EditText>(R.id.text)
            val input = editText.text.toString()
            val bundle=Bundle()
            bundle.putString("data",input)
            val fragment= SecondFragment()
            fragment.arguments=bundle
            fragmentManager?.beginTransaction()?.replace(R.id.navController,fragment)?.commit()
        }
        return view
    }
}





