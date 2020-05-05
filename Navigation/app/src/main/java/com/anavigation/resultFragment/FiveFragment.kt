package com.anavigation.resultFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.anavigation.MainActivityViewModel
import com.anavigation.R
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class FiveFragment : Fragment() {

    lateinit var btnToHome: Button

    private val viewModel: MainActivityViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.allServices.observe(requireActivity(), Observer { services ->
            services ?: return@Observer
            // servicesAdapter.setServices(services.toAdapterTypes())
            //servicesAdapter.setServices(services)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_five, container, false)

        btnToHome = view.findViewById(R.id.btn_five)
        btnToHome.setOnClickListener {
            findNavController().navigate(R.id.action_fiveFragment_to_oneFragment)
        }

        return view
    }


}
