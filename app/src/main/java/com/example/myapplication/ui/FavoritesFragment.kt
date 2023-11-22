package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.SharedPrefs
import com.example.myapplication.databinding.FragmentFavoritesBinding
import com.example.myapplication.ui.adapter.FavScreenAdapter
import com.example.myapplication.ui.vm.FavScreenVm

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var sharedPrefs: SharedPrefs
    private var adapter = FavScreenAdapter(arrayListOf())
    private lateinit var viewModel: FavScreenVm

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefs = SharedPrefs(requireContext())
        binding = FragmentFavoritesBinding.bind(view)

        // Create an instance of your ViewModel using the sharedPrefs
        viewModel = ViewModelProvider(this, FavScreenVm.FavScreenVmFactory(sharedPrefs))[FavScreenVm::class.java]
        // get data from viewModel shared preferences
        viewModel.getFavData()
        binding.favoritesList.adapter = adapter
        binding.favoritesList.layoutManager = LinearLayoutManager(context)
        observeFavData()
    }

    private fun observeFavData() {
        viewModel.favCocktailList.observe(viewLifecycleOwner) { favCocktails ->
            favCocktails?.let {
                adapter.updateFavData(favCocktails)
            }
        }
    }
}
