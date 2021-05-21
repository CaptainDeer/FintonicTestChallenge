package com.captaindeer.beersintheworld.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.captaindeer.beersintheworld.data.local.entities.*

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(localBeer: BeerEntity)

    @Query(value = "select * from BEERS")
    fun updatePosts(): List<BeerEntity>

}