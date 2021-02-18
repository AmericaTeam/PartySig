package org.allamericateam.partysig.screens
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import org.allamericateam.partysig.MainActivity
import org.allamericateam.partysig.MainViewModel
import org.allamericateam.partysig.R
import org.allamericateam.partysig.databinding.FragmentSignatureRecipientBinding

class SignatureRecipientFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentSignatureRecipientBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_signature_recipient, container, false)

        viewModel = ViewModelProvider(activity as MainActivity).get(MainViewModel::class.java)

//        if (!viewModel.getRecipientNames().isNullOrEmpty()) {
//            binding.signatureRecipientsNameTextField.editText!!.setText(viewModel.getRecipientNames())
//            binding.signatureRecipientsEmailTextField.editText!!.setText(viewModel.getRecipientEmails())
//        }
//
//        binding.previewButton.setOnClickListener {
//            when {
//                TextUtils.isEmpty(binding.signatureRecipientsEmailTextField.editText!!.text) -> Snackbar
//                    .make(binding.root, "Please enter name(s) of the signature recipient(s)!", Snackbar.LENGTH_SHORT)
//                    .show()
//
//                TextUtils.isEmpty(binding.signatureRecipientsEmailTextField.editText!!.text) -> Snackbar
//                    .make(binding.root, "Please enter email(s) of the signature recipient(s)!", Snackbar.LENGTH_SHORT)
//                    .show()
//
//                else -> {
//                    // Code for successful submission
//
//                    val namesString = binding.signatureRecipientsNameTextField.editText!!.text.toString()
//                    val names =
//                        namesString.split(",").toList()
//                    Log.d("Names", names.toString())
//
//                    val emailsString = binding.signatureRecipientsEmailTextField.editText!!.text.toString()
//                    val emails = emailsString
//                        .replace("\\s".toRegex(), "")
//                        .split(",").toList()
//                    Log.d("Emails", emails.toString())
//
//                    // Save names and emails to viewModels
//                    viewModel.setRecipientNames(namesString)
//                    viewModel.setRecipientEmails(emailsString)
//
//
//
//                    findNavController().navigate(R.id.action_signatureRecipientFragment_to_previewFragment)
//                }
//            }
//        }

        return binding.root
    }
}