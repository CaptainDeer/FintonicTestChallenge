package com.captaindeer.beersintheworld.data.remote.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MashTempResponse(
    @SerializedName(value = "temp") val temp: TempResponse,
    @SerializedName(value = "duration") val duration: Float
) : Serializable
