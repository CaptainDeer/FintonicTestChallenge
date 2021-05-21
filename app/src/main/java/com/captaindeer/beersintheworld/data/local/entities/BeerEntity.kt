package com.captaindeer.beersintheworld.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BEERS")
class BeerEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int? = null,
    @ColumnInfo(name = "name") val name: String? = null,
    @ColumnInfo(name = "description") val description: String? = null,
    @ColumnInfo(name = "image_url") val image_url: String? = null,
    @ColumnInfo(name = "brewers_tips") val brewers_tips: String? = null,
    @ColumnInfo(name = "contributed_by") val contributed_by: String? = null
)