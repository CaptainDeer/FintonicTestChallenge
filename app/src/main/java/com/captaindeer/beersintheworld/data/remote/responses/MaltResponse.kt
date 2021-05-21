package com.captaindeer.beersintheworld.data.remote.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MaltResponse(
    @SerializedName(value = "name") val name: String,
    @SerializedName(value = "amount") val amount: AmountResponse
) : Serializable
