package com.captaindeer.beersintheworld.data.remote.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HopsResponse(
    @SerializedName(value = "name") val name: String,
    @SerializedName(value = "amount") val amount: AmountResponse,
    @SerializedName(value = "add") val add: String,
    @SerializedName(value = "attribute") val attribute: String
) : Serializable
