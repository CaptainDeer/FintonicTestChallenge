package com.captaindeer.beersintheworld.data.remote.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BeerResponse(
    @SerializedName(value = "id") val id: Int,
    @SerializedName(value = "name") val name: String,
    @SerializedName(value = "tagline") val tagline: String,
    @SerializedName(value = "first_brewed") val first_brewed: String,
    @SerializedName(value = "description") val description: String,
    @SerializedName(value = "image_url") val image_url: String,
    @SerializedName(value = "abv") val abv: Float,
    @SerializedName(value = "ibu") val ibu: Float,
    @SerializedName(value = "target_fg") val target_fg: Float,
    @SerializedName(value = "target_og") val target_og: Float,
    @SerializedName(value = "ebc") val ebc: Float,
    @SerializedName(value = "srm") val srm: Float,
    @SerializedName(value = "ph") val ph: Float,
    @SerializedName(value = "attenuation_level") val attenuation_level: Float,
    @SerializedName(value = "volume") val volume: VolumeResponse,
    @SerializedName(value = "boil_volume") val boil_volume: BoilVolumeResponse,
    @SerializedName(value = "method") val method: MethodResponse,
    @SerializedName(value = "ingredients") val ingredients: IngredientsResponse,
    @SerializedName(value = "food_pairing") val food_pairing: ArrayList<String>,
    @SerializedName(value = "brewers_tips") val brewers_tips: String,
    @SerializedName(value = "contributed_by") val contributed_by: String
) : Serializable