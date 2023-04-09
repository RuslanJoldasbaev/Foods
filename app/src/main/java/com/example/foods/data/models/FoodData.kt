package com.example.foods.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class FoodData(
    @PrimaryKey val id: Int,
    val image: String,
    val name: String,
    val sum: String,
    val delivery_info: String,
    val return_policy: String,
    val foodMenu: String,
    val is_favorite: Boolean
)
