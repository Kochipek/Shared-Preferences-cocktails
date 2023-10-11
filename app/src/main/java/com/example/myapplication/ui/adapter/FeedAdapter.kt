package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.model.CocktailModel
import com.example.myapplication.databinding.FeedRowBinding

class FeedAdapter(private val cocktailList : ArrayList<CocktailModel>) :
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    // ViewHolder class i  olusturmamizin sebebi RecyclerView'in her bir item'ini tutmasi
    // TODO binding.root ?
    class FeedViewHolder(private val binding : FeedRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cocktailModel : CocktailModel) {
            binding.CocktailTitle.text = cocktailModel.strDrink
            Glide.with(binding.imageView.context)
                .load(cocktailModel.strDrinkThumb)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {

//                                 ************************************
//         parent.context fragment'in context'ini mi veriyor bu sekilde inflate edip ui ile baglanti kuruyoruz?

        val binding = FeedRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cocktailList.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(cocktailList[position])
    }

}