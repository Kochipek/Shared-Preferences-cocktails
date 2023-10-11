package com.example.myapplication.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFeedBinding
import com.example.myapplication.ui.adapter.FeedAdapter
import com.example.myapplication.ui.vm.FeedVm

class FeedFragment : Fragment(R.layout.fragment_feed) {
    private lateinit var binding : FragmentFeedBinding
    private lateinit var viewModel : FeedVm
    private var adapter = FeedAdapter(arrayListOf())


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFeedBinding.bind(view)
        viewModel = androidx.lifecycle.ViewModelProvider(this).get(FeedVm::class.java)
        // get data from viewModel coroutine
        viewModel.getData()
        binding.cocktailList.adapter = adapter
        binding.cocktailList.layoutManager = LinearLayoutManager(context) //! TODO ogeren
    }
    }