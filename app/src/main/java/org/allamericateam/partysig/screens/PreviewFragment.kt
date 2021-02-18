package org.allamericateam.partysig.screens
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import org.allamericateam.partysig.MainActivity
import org.allamericateam.partysig.MainViewModel
import org.allamericateam.partysig.R
import org.allamericateam.partysig.databinding.FragmentPreviewBinding
import org.allamericateam.partysig.interfaces.AnvilFillPdfAPI
import org.allamericateam.partysig.pojo.Data
import org.allamericateam.partysig.pojo.FillUpFormRequest
import org.allamericateam.partysig.utills.Authenticate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.nio.file.Files.createFile


class PreviewFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private lateinit var baseUrl : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentPreviewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_preview, container, false)


        val fileName = "E8xUEB2g3kRCkyFQOdre.pdf"
        baseUrl = getString(R.string.pdf_gen_base_url) + "/api/v1/fill/"


        viewModel = ViewModelProvider(activity as MainActivity).get(MainViewModel::class.java)

        val form = viewModel.getForm()

        if (form != null) {
            binding.adlTeamNameTextView.text = form.teamName
            binding.captainFirstNameTextView.text = form.captainFirstName
            binding.captainMiddleNameTextView.text = form.captainMiddleName
            binding.captainLastNameTextView.text = form.captainLastName
            binding.captainAdlRatingTextView.text = form.captainAdlRating
            binding.captainEmailTextView.text = form.captainEmailAddress
            binding.captainCardNumberTextView.text = form.captainCardNumber
            binding.captainPhoneTextView.text = form.captainPhone
            binding.playerFirstNameTextView.text = form.playerFirstName
            binding.playerMiddleNameTextView.text = form.playerMiddleName
            binding.playerLastNameTextView.text = form.playerLastName
            binding.playerAdlRatingTextView.text = form.playerAdlRating
            binding.playerEmailTextView.text = form.playerEmailAddress
            binding.playerPhoneTextView.text = form.playerPhone
            binding.playerCardNumberTextView.text = form.playerCardNumber
            binding.firstChoiceNightTextView.text = form.firstChoiceNight
            binding.secondChoiceNightTextView.text = form.secondChoiceNight
            binding.streetAddressTextView.text = form.streetAddress
            binding.addressLine2TextView.text = form.streetAddress2
            binding.cityTextView.text = form.city
            binding.stateTextView.text = form.state
            binding.zipTextView.text = form.zip



            binding.submitButton.setOnClickListener {






                /* Create Retrofit Object */
                var retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                var fillUpPdfApi : AnvilFillPdfAPI = retrofit.create(AnvilFillPdfAPI::class.java)
                var encodedToken = Authenticate(getString(R.string.anvil_api_key)).encodedToken
//                var requestBody : FillUpFormRequest(Data(),)

                var data = "{\n" +
                        "    \"Location\": \"${form.city}\",\n" +
                        "    \"firstchoice\": \"${form.firstChoiceNight}\",\n" +
                        "    \"secondchoice\": \"${form.secondChoiceNight}\",\n" +
                        "    \"teamName\": \"${form.teamName}\",\n" +
                        "    \"captainName\": {\n" +
                        "      \"firstName\": \"${form.captainFirstName}\",\n" +
                        "      \"mi\": \"${form.captainMiddleName}\",\n" +
                        "      \"lastName\": \"${form.captainLastName}\"\n" +
                        "    },\n" +
                        "    \"captainRaiting\": ${form.captainAdlRating},\n" +
                        "    \"captainCardNumber\": \"${form.captainCardNumber}\",\n" +
                        "    \"captainPhoneNumber\": {\n" +
                        "      \"num\": \"${form.captainPhone}\",\n" +
                        "      \"region\": \"US\",\n" +
                        "      \"baseRegion\": \"US\"\n" +
                        "    },\n" +
                        "    \"captainEmail\": \"${form.captainEmailAddress}\",\n" +
                        "    \"teammateName\": {\n" +
                        "      \"firstName\": \"${form.playerFirstName}\",\n" +
                        "      \"mi\": \"${form.playerMiddleName}\",\n" +
                        "      \"lastName\": \"${form.playerLastName}\"\n" +
                        "    },\n" +
                        "    \"teammateRaiting\": ${form.playerAdlRating},\n" +
                        "    \"teammateCardNumber\": \"${form.playerCardNumber}\",\n" +
                        "    \"teammatePhoneNumber\": {\n" +
                        "      \"num\": \"${form.playerPhone}\",\n" +
                        "      \"region\": \"US\",\n" +
                        "      \"baseRegion\": \"US\"\n" +
                        "    },\n" +
                        "    \"teammateEmail\": \"${form.playerEmailAddress}\"\n" +
                        "  }"
                var call : Call<ResponseBody> = fillUpPdfApi.fillUpPdf(encodedToken,
                fileName,FillUpFormRequest(data, 10, "#a824e8", "ADL SPRING 2020 ENTRY FORM"))

                call.enqueue(object : Callback<ResponseBody> {
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        if(response.isSuccessful){
//                            response.body()?.byteStream()?.saveToFile("${"ADL SPRING 2020 ENTRY FORM " + System.currentTimeMillis()}.pdf")
//                            var path = context?.getExternalFilesDir(null)
//                            val directory = File(path, "PDF")
//                            directory.mkdirs()
//                            var file = File(directory, "ADL_SPRING_2020_ENTRY_FORM_" + System.currentTimeMillis() + ".pdf")
//                            FileOutputStream(file).use{
//                                it.write(response.body()?.byteStream()?.readBytes())
//                            }

//                            response.body()?.byteStream()?.saveToFile("ADL SPRING 2020 ENTRY FORM ${System.currentTimeMillis()}.pdf")
                            var fileSizeDownloaded : Long = 0
                            var fileReader : ByteArray = ByteArray(4096)
                            var inputStream = response.body()?.byteStream()
//                            var path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
                            var path = context?.getExternalFilesDir(null)?.absolutePath
                            var file = File(path + "/" + "ADL SPRING 2020 ENTRY FORM ${System.currentTimeMillis()}.pdf")
                            var outputStream = FileOutputStream(file)

                            while(true){
                                var read = inputStream!!.read(fileReader)

                                if(read == -1){
                                    break
                                }

                                outputStream.write(fileReader, 0, read)
                                fileSizeDownloaded += read;
                            }

                            outputStream.flush()

                            var uri = FileProvider.getUriForFile(binding.root.context, binding.root.context.applicationContext.packageName + ".provider",
                                file)
                            val intent = Intent().setAction(Intent.ACTION_VIEW)
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                            intent.setDataAndType(uri, "application/pdf")
                            try {
                                startActivity(intent)
                            }catch (e : ActivityNotFoundException){
                                e.printStackTrace()
                            }

                        }else{
                            print(response.errorBody()?.string())
                        }

                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        t.printStackTrace()
                    }
                })


//
//                (
//                    Data(),10,"#a824e8", "ADL SPRING 2020 ENTRY FORM"
//                )

                Snackbar.make(binding.root, "Form has been sent!", Snackbar.LENGTH_SHORT)
                        .show()
            }

        }



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



//    fun saveFile(inputStream: InputStream, filePath: String) {
//        //저장할 파일
//        val saveFile = File(filePath)
//
//        saveFile.outputStream().use { fileOutput ->
//            inputStream.copyTo(fileOutput)
//        }
//    }


    private fun InputStream.saveToFile(file: String) = use { input ->
        File(file).outputStream().use { output ->
            input.copyTo(output)
        }
    }
}