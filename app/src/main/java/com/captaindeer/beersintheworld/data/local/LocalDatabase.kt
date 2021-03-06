package com.captaindeer.beersintheworld.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.captaindeer.beersintheworld.data.local.dao.ProductDao
import com.captaindeer.beersintheworld.data.local.entities.BeerEntity

@Database(entities = [BeerEntity::class], version = 2, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var instance: LocalDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{ instance = it}
        }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, LocalDatabase::class.java, "BeerAroundTheWorld.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}