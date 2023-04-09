package com.example.foods.ui.food

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.foods.MainActivity
import com.example.foods.R
import com.example.foods.databinding.FragmentFoodBinding

class FoodFragment:Fragment(R.layout.fragment_food) {
    private lateinit var binding: FragmentFoodBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFoodBinding.bind(view)
        (requireActivity() as MainActivity).visibilityOfBottomNavigation(View.GONE)

    }

}