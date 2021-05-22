package com.captaindeer.beersintheworld.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BEERS")
class BeerEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "image_url") val image_url: String?,
    @ColumnInfo(name = "brewers_tips") val brewers_tips: String,
    @ColumnInfo(name = "contributed_by") val contributed_by: String
)