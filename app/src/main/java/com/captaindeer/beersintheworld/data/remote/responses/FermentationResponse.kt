package com.captaindeer.beersintheworld.data.remote.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FermentationResponse(
    @SerializedName(value = "temp") val temp: TempResponse
) : Serializable
