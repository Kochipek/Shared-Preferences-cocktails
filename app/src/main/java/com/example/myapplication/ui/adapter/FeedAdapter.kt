package com.example.myapplication.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.SharedPrefs
import com.example.myapplication.data.model.CocktailModel
import com.example.myapplication.databinding.FeedRowBinding


class FeedAdapter(private val cocktailList: ArrayList<CocktailModel>) :
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    class FeedViewHolder(
        private val binding: FeedRowBinding,
        private val sharedPrefs: SharedPrefs
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cocktailModel: CocktailModel) {
            binding.CocktailTitle.text = cocktailModel.strDrink
            Glide.with(binding.imageView.context)
                .load(cocktailModel.strDrinkThumb)
                .into(binding.imageView)

            var isFavorite = sharedPrefs.getFavorites().contains(cocktailModel)
            updateHeartButton(isFavorite)
            binding.starButton.setOnClickListener {
                if (isFavorite) {
                    sharedPrefs.removeFavorite(cocktailModel)
                    println(sharedPrefs.getFavorites())
                } else {
                    sharedPrefs.addFavorite(cocktailModel)
                    println(sharedPrefs.getFavorites())

                }
                isFavorite = !isFavorite
                updateHeartButton(isFavorite)
            }
        }

        private fun updateHeartButton(isFavorite: Boolean) {
            if (isFavorite) {
                binding.starButton.setImageResource(R.drawable.star)
            } else {
                binding.starButton.setImageResource(R.drawable.favorite)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val binding = FeedRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewHolder(binding, SharedPrefs(parent.context))

    }

    override fun getItemCount(): Int {
        return cocktailList.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(cocktailList[position])
    }

    fun updateData(cocktails: List<CocktailModel>) {
        cocktailList.clear()
        cocktailList.addAll(cocktails)
        notifyDataSetChanged()
    }

}