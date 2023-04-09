package com.example.foods.ui.like

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.foods.R
import com.example.foods.databinding.FragmentLikeBinding

class LikeFragment : Fragment(R.layout.fragment_like) {
    private lateinit var binding: FragmentLikeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLikeBinding.bind(view)

    }
}