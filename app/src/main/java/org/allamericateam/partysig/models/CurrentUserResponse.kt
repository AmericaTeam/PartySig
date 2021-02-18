package org.allamericateam.partysig.models

import com.google.gson.annotations.SerializedName

data class CurrentUserResponse(
    @SerializedName("data") val data: Map<Any?, Any?>
    )