package com.example.data.network.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RatingDTO(

	@field:SerializedName("rate")
	val rate: Any? = null,

	@field:SerializedName("count")
	val count: Int? = null
)