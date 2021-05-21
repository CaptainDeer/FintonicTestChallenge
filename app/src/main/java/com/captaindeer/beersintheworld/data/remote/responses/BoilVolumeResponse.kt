package com.captaindeer.beersintheworld.data.remote.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BoilVolumeResponse(
    @SerializedName(value = "value") val value: Float,
    @SerializedName(value = "unit") val unit: String
) : Serializable
