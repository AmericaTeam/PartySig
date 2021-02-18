package org.allamericateam.partysig.interfaces

import okhttp3.ResponseBody
import org.allamericateam.partysig.models.CurrentUserResponse
import org.allamericateam.partysig.pojo.CurrentUserRequest
import org.allamericateam.partysig.pojo.FillUpFormRequest
import retrofit2.Call
import retrofit2.http.*

interface AnvilFillPdfAPI {


    @Headers( "Content-Type:application/json" )
    @POST("{fileName}")
    fun fillUpPdf(
        @Header("Authorization") authorization: String,
        @Path("fileName") fileName : String,
        @Body requestBody : FillUpFormRequest
    ) : Call<ResponseBody>
}