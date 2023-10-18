package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.SharedPrefs
import com.example.myapplication.data.model.CocktailModel
import com.example.myapplication.databinding.FavoritesRowBinding

class FavScreenAdapter(private val favCocktailList: ArrayList<CocktailModel>) :
    RecyclerView.Adapter<FavScreenAdapter.FavScreenViewHolder>() {
    class FavScreenViewHolder(
        private val binding: FavoritesRowBinding,
        private val sharedPrefs: SharedPrefs,
        private val adapter : FavScreenAdapter
    ) :
        RecyclerView.ViewHolder(binding.root) {
                fun bind(cocktailModel: CocktailModel) {
                    binding.favCocktailTitle.text = cocktailModel.strDrink
                    Glide.with(binding.imageView2.context)
                        .load(cocktailModel.strDrinkThumb)
                        .into(binding.imageView2)

                    binding.deleteButton.setOnClickListener {
                        sharedPrefs.removeFavorite(cocktailModel)
                        adapter.updateFavData(sharedPrefs.getFavorites())
                    }
                }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavScreenViewHolder {
        val binding = FavoritesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavScreenViewHolder(binding, SharedPrefs(parent.context), this)
    }

    override fun getItemCount(): Int {
        return favCocktailList.size
    }

    override fun onBindViewHolder(holder: FavScreenViewHolder, position: Int) {
        val cocktail = favCocktailList[position]
        holder.bind(cocktail)
    }

        fun updateFavData(cocktails: List<CocktailModel>) {
            favCocktailList.clear()
            favCocktailList.addAll(cocktails)
            notifyDataSetChanged()
        }

    }