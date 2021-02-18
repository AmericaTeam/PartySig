package org.allamericateam.partysig

import android.os.Build
import android.os.Bundle
import android.os.Environment
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.allamericateam.partysig.R
import org.allamericateam.partysig.interfaces.AnvilCurrentUserAPI
import org.allamericateam.partysig.interfaces.EtchEsignApi
import org.allamericateam.partysig.models.CurrentUserResponse
import org.allamericateam.partysig.pojo.CurrentUserRequest
import org.allamericateam.partysig.utills.Authenticate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var encodedToken : String
    lateinit var graphqlBaseUrl : String

    private lateinit var viewModel: MainViewModel
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)



        graphqlBaseUrl = getString(R.string.graphql_base_url)
        init()
//        encodedToken = Base64.getEncoder().encodeToString((getString(R.string.anvil_api_key) + ":").toByteArray())
        //print(encodedToken)


//        encodedToken = "Basic " + encodedToken



//        /* Create Retrofit Object */
//        var retrofit = Retrofit.Builder()
//            .baseUrl(graphqlBaseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()


//        var etchEsignQuery : String =
//                "mutation (\n    $name: String,\n    $files: [EtchFile!],\n    $isDraft: Boolean,\n    $isTest: Boolean,\n    $signatureEmailSubject: String,\n    $signatureEmailBody: String,\n    $signatureProvider: String,\n    $signaturePageOptions: JSON,\n    $signers: [JSON!],\n    $data: JSON,\n) {\n    createEtchPacket (\n        name: $name,\n        files: $files,\n        isDraft: $isDraft,\n        isTest: $isTest,\n        signatureEmailSubject: $signatureEmailSubject,\n        signatureEmailBody: $signatureEmailBody,\n        signatureProvider: $signatureProvider,\n        signaturePageOptions: $signaturePageOptions,\n        signers: $signers,\n        data: $data\n    ) {\n        eid\n        name\n        detailsURL\n        documentGroup {\n            eid\n            status\n            signers {\n                eid\n                name\n                email\n                status\n                routingOrder\n            }\n        }\n    }\n}",

//        var anvilCurrentUser : AnvilCurrentUserAPI = retrofit.create(AnvilCurrentUserAPI::class.java)
//        var call : Call<CurrentUserResponse> = anvilCurrentUser.auth(encodedToken, CurrentUserRequest())
//        call.enqueue(object : Callback<CurrentUserResponse> {
//
//            override fun onResponse(
//                    call: Call<CurrentUserResponse>,
//                    response: Response<CurrentUserResponse>
//            ) {
//                print(response.message())
//            }
//
//            override fun onFailure(call: Call<CurrentUserResponse>, t: Throwable) {
//                t.printStackTrace()
//            }
//        })








    }


    fun init(){
        Authenticate((getString(R.string.anvil_api_key) + ":"))

        isExternalStorageWritable()
    }


    // If external storage status is media-mounted,
    fun isExternalStorageWritable() : Boolean{
        when{

            Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED -> return true
            else -> return false
        }
    }

}