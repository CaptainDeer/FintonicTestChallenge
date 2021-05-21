package com.captaindeer.beersintheworld.data.remote.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class IngredientsResponse(
    @SerializedName(value = "malt") val malt: ArrayList<MaltResponse>,
    @SerializedName(value = "hops") val hops: ArrayList<HopsResponse>,
    @SerializedName(value = "yeast") val yeast: String
) : Serializable
