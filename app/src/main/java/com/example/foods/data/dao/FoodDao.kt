package com.example.foods.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.foods.data.models.FoodData

@Dao()
interface FoodDao {
    @Query("SELECT *FROM foods Where foodMenu=:foodMenu")
    fun getAllFoods(foodMenu: String): List<FoodData>

    @Query("SELECT * FROM foods WHERE name like :searchValue and foodMenu=:foodMenu")
    fun search(searchValue: String, foodMenu: String): List<FoodData>

    @Query("SELECT * FROM foods WHERE is_favorite=1")
    fun getFavorites(): List<FoodData>
}