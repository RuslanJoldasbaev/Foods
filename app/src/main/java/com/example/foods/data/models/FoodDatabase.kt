package com.example.foods.data.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foods.data.dao.FoodDao

@Database(entities = [FoodData::class], version = 3)
abstract class FoodDatabase : RoomDatabase() {
    companion object {
        private var INSTANCE: FoodDatabase? = null

        fun getInstance(context: Context): FoodDatabase {
            INSTANCE?.let {
                return it
            }

            val db = Room.databaseBuilder(
                context, FoodDatabase::class.java, "food.db"
            )
                .createFromAsset("food.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()

            INSTANCE = db
            return db
        }
    }
    abstract fun getFoodDao(): FoodDao
}