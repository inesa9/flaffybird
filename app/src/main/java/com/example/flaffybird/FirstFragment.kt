package com.example.flappybird

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FirstFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, //pour transformer le xml en view
        container: ViewGroup?, //accueillera le fragment
        savedInstanceState: Bundle? //méthode Kotlin pour passer des données d'une partie du code à une autre
    ): View? {

        val view = inflater!!.inflate(R.layout.first_fragment,container,false)

        val tv = view.findViewById<ImageView>(R.id.background)

        val button = view.findViewById<Button>(R.id.demarre)

        button.setOnClickListener{

        }

        return view
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }
}
