package com.captaindeer.beersintheworld.data.remote.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MethodResponse(
    @SerializedName(value = "mash_temp") val mash_temp: ArrayList<MashTempResponse>,
    @SerializedName(value = "fermentation") val fermentation: FermentationResponse,
    @SerializedName(value = "twist") val twist: String
) : Serializable
