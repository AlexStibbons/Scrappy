package com.anavigation.questionFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.anavigation.MainActivityViewModel
import com.anavigation.R
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FourFragment : Fragment() {

    lateinit var btnFour: Button

    private val viewModel: MainActivityViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_four, container, false)

        btnFour = view.findViewById(R.id.btn_four)
        btnFour.setOnClickListener {
            findNavController().navigate(R.id.action_fourFragment_to_fiveFragment)
        }

     /*   btnNo.setOnClickListener {
            viewModel.removeService("Clothes") // yay, works!
            // Log.e("VM TEST", "LIST: ${viewModel.allServices.value}")
            findNavController().navigate(R.id.action_oneFragment_to_twoFragment)
        }*/

        return view
    }


}
