package com.example.foods.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foods.R
import com.example.foods.data.models.FoodData
import com.example.foods.databinding.ItemFoodBinding

class FoodAdapterHome : Adapter<FoodAdapterHome.FoodViewHolder>() {

    inner class FoodViewHolder(private var binding: ItemFoodBinding) : ViewHolder(binding.root) {
        fun bind(foodData: FoodData) {
            binding.apply {
                if (foodData.image.isNotEmpty()) {
                    val id = root.context.resources.getIdentifier(
                        foodData.image,
                        "drawable",
                        root.context.packageName
                    )
                    foodItem.setImageResource(id)
                }
                foodItemText.text = foodData.name
                itemSwmText.text = foodData.sum
            }
        }
    }

    var models = mutableListOf<FoodData>()
        @SuppressLint("NotifyDataSetChanged") set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        val binding = ItemFoodBinding.bind(v)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(models[position])
    }

    private var onFavoriteClick: (foodData: FoodData, position: Int) -> Unit = { _, _ -> }
    fun setOnFavoriteClickListener(onFavoriteClick: (foodData: FoodData, position: Int) -> Unit) {
        this.onFavoriteClick = onFavoriteClick
    }

    private var onItemClick: (foodData: FoodData, position: Int) -> Unit = { _, _ -> }
    fun setOnItemClickListener(onItemClick: (foodData: FoodData, position: Int) -> Unit) {
        this.onItemClick = onItemClick
    }
}