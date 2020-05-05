package com.anavigation.questionFragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.anavigation.MainActivityViewModel
import com.anavigation.R
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 */
class ThreeFragment : Fragment() {

    private val viewModel: MainActivityViewModel by sharedViewModel()

    lateinit var btnToFour: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_three, container, false)

        Log.e("WHATS LEFT", "LIST: ${viewModel.allServices.value}")

        btnToFour = view.findViewById(R.id.btn_three)
        btnToFour.setOnClickListener {
            findNavController().navigate(R.id.action_threeFragment_to_fourFragment)
        }

      /*  btnNo.setOnClickListener {
            viewModel.removeService("Pets") // yay, works!
            // Log.e("VM TEST", "LIST: ${viewModel.allServices.value}")
            findNavController().navigate(R.id.action_oneFragment_to_twoFragment)
        }*/

        return view
    }


}
