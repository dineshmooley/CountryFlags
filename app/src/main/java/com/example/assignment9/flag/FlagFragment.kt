package com.example.assignment9.flag


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment9.R
import com.example.assignment9.databinding.FragmentFlagBinding
import com.example.assignment9.network.CountriesContainer

class FlagFragment : Fragment() {
    private lateinit var binding: FragmentFlagBinding
    private lateinit var viewModel: FlagViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flag, container, false)
        viewModel = ViewModelProvider(this)[FlagViewModel::class.java]

        // Set viewModel and lifecycle owner for data binding
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.countries.observe(viewLifecycleOwner, Observer {
            if(it!=null) binding.flagGrid.adapter = FlagAdapter(it)
        })

//         = viewModel.countries.value?.let { FlagAdapter(it) }
//        binding.flagGrid.adapter = adapter


        return binding.root
    }
}
