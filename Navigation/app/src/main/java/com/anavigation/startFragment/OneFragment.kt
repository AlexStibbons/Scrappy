package com.anavigation.startFragment

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

class OneFragment : Fragment() {

    lateinit var btnStart: Button

    private val viewModel: MainActivityViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
                }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_one, container, false)

        btnStart = view.findViewById(R.id.btn_one)

        btnStart.setOnClickListener {
            // navigate by ACTIONS OR DESTINATION defined in the NAV_GRAPH
            findNavController().navigate(R.id.action_oneFragment_to_twoFragment)
        }

        return view
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            OneFragment().apply {
                arguments = Bundle().apply {
                                 }
            }
    }
}
