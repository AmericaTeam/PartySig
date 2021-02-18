package org.allamericateam.partysig.utills

import android.os.Build
import androidx.annotation.RequiresApi
import org.allamericateam.partysig.R
import java.util.*


class Authenticate {

    val encodedToken : String

    constructor(apiKey: String) {
        val temp = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Base64.getEncoder().encodeToString((apiKey + ":").toByteArray()).toString()
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        this.encodedToken = "Basic " + temp
    }


    companion object {
        fun getAuthToken() {
            return
        }
    }


}