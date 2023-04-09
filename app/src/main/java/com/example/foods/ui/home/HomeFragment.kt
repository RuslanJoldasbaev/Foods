package com.example.foods.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.foods.MainActivity
import com.example.foods.R
import com.example.foods.data.dao.FoodDao
import com.example.foods.data.models.FoodDatabase
import com.example.foods.databinding.FragmentHomeBinding
import com.example.foods.ui.adapters.FoodAdapterHome

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val adapter = FoodAdapterHome()
    private lateinit var db: FoodDatabase
    private lateinit var dao: FoodDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        (requireActivity() as MainActivity).visibilityOfBottomNavigation(View.VISIBLE)

        db = FoodDatabase.getInstance(requireContext())
        dao = db.getFoodDao()

        binding.apply {
            kategoriyRecyclerView.adapter = adapter
            bottomNavigationFood.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.btm_1 -> {
                        dao.getAllFoods(item.title.toString())
                        search1.addTextChangedListener {
                            val searchValue = it.toString()
                            dao.search(searchValue, item.title.toString())
                        }
                        true
                    }
                    R.id.btm_2 -> {
                        dao.getAllFoods(item.title.toString())
                        search1.addTextChangedListener {
                            val searchValue = it.toString()
                            dao.search(searchValue, item.title.toString())
                        }
                        true
                    }
                    R.id.btm_3 -> {
                        dao.getAllFoods(item.title.toString())
                        search1.addTextChangedListener {
                            val searchValue = it.toString()
                            dao.search(searchValue, item.title.toString())
                        }
                        true
                    }
                    else -> false
                }
            }
        }
    }
}