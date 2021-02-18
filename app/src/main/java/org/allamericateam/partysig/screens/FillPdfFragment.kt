package org.allamericateam.partysig.screens

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController


import com.google.android.material.snackbar.Snackbar
import org.allamericateam.partysig.MainActivity
import org.allamericateam.partysig.MainViewModel
import org.allamericateam.partysig.R
import org.allamericateam.partysig.databinding.FragmentFillPdfBinding
import org.allamericateam.partysig.models.FormEntries

class FillPdfFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentFillPdfBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_fill_pdf, container, false)

        viewModel = ViewModelProvider(activity as MainActivity).get(MainViewModel::class.java)

        // Dropdown
        val items = listOf("ELITE DOUBLES – Sat. 4:00 p.m.",
            "A DOUBLES – Sun 9:30 a.m.",
            "BB DOUBLES – Fri 2:00 p.m.",
            "B DOUBLES – Sat 9:00 a.m.",
            "CC DOUBLES – Sun 9:00 a.m.",
            "C DOUBLES – Sat 9:00 a.m.")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        (binding.firstChoiceNightTextField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        (binding.secondChoiceNightTextField.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        // Dropdown states
        val states = listOf("AK - Alaska",
            "AL - Alabama",
            "AR - Arkansas",
            "AS - American Samoa",
            "AZ - Arizona",
            "CA - California",
            "CO - Colorado",
            "CT - Connecticut",
            "DC - District of Columbia",
            "DE - Delaware",
            "FL - Florida",
            "GA - Georgia",
            "GU - Guam",
            "HI - Hawaii",
            "IA - Iowa",
            "ID - Idaho",
            "IL - Illinois",
            "IN - Indiana",
            "KS - Kansas",
            "KY - Kentucky",
            "LA - Louisiana",
            "MA - Massachusetts",
            "MD - Maryland",
            "ME - Maine",
            "MI - Michigan",
            "MN - Minnesota",
            "MO - Missouri",
            "MS - Mississippi",
            "MT - Montana",
            "NC - North Carolina",
            "ND - North Dakota",
            "NE - Nebraska",
            "NH - New Hampshire",
            "NJ - New Jersey",
            "NM - New Mexico",
            "NV - Nevada",
            "NY - New York",
            "OH - Ohio",
            "OK - Oklahoma",
            "OR - Oregon",
            "PA - Pennsylvania",
            "PR - Puerto Rico",
            "RI - Rhode Island",
            "SC - South Carolina",
            "SD - South Dakota",
            "TN - Tennessee",
            "TX - Texas",
            "UT - Utah",
            "VA - Virginia",
            "VI - Virgin Islands",
            "VT - Vermont",
            "WA - Washington",
            "WI - Wisconsin",
            "WV - West Virginia",
            "WY - Wyoming")
        val stateAdapter = ArrayAdapter(requireContext(), R.layout.list_item, states)
        (binding.stateTextField.editText as? AutoCompleteTextView)?.setAdapter(stateAdapter)


        val form = viewModel.getForm()
        if (form != null) {
            binding.adlTeamNameTextField.editText!!.setText(form.teamName)
            binding.captainFirstNameTextField.editText!!.setText(form.captainFirstName)
            binding.captainMiddleNameTextField.editText!!.setText(form.captainMiddleName)
            binding.captainLastNameTextField.editText!!.setText(form.captainLastName)
            binding.captainAdlRatingTextField.editText!!.setText(form.captainAdlRating)
            binding.captainEmailTextField.editText!!.setText(form.captainEmailAddress)
            binding.captainCardNumberTextField.editText!!.setText(form.captainCardNumber)
            binding.captainPhoneTextField.editText!!.setText(form.captainPhone)
            binding.playerFirstNameTextField.editText!!.setText(form.playerFirstName)
            binding.playerMiddleNameTextField.editText!!.setText(form.playerMiddleName)
            binding.playerLastNameTextField.editText!!.setText(form.playerLastName)
            binding.playerAdlRatingTextField.editText!!.setText(form.playerAdlRating)
            binding.playerEmailTextField.editText!!.setText(form.playerEmailAddress)
            binding.playerPhoneTextField.editText!!.setText(form.playerPhone)
            binding.playerCardNumberTextField.editText!!.setText(form.playerCardNumber)
            binding.streetAddressTextField.editText!!.setText(form.streetAddress)
            binding.addressLine2TextField.editText!!.setText(form.streetAddress2)
            binding.cityTextField.editText!!.setText(form.city)
            binding.stateTextField.editText!!.setText(form.state)
            binding.zipTextField.editText!!.setText(form.zip)

            // TODO: Retrieve dropdown value?
            binding.firstChoiceNightTextField.editText!!.setText(form.firstChoiceNight)
            binding.secondChoiceNightTextField.editText!!.setText(form.secondChoiceNight)
        }

        binding.nextButton.setOnClickListener {
            when {

                TextUtils.isEmpty(binding.adlTeamNameTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please ADL team name", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.captainFirstNameTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please captain's first name", Snackbar.LENGTH_SHORT)
                    .show()

//                TextUtils.isEmpty(binding.captainMiddleNameTextField.editText!!.text) -> Snackbar
//                    .make(binding.root, "Please captain's middle name", Snackbar.LENGTH_SHORT)
//                    .show()

                TextUtils.isEmpty(binding.captainLastNameTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please captain's last name", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.captainAdlRatingTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please captain's ADL rating", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.captainEmailTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please captain's email address", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.captainCardNumberTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please captain's card number", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.captainPhoneTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please captain's phone number", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.playerFirstNameTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please player's first name", Snackbar.LENGTH_SHORT)
                    .show()

//                TextUtils.isEmpty(binding.playerMiddleNameTextField.editText!!.text) -> Snackbar
//                    .make(binding.root, "Please player's middle name", Snackbar.LENGTH_SHORT)
//                    .show()

                TextUtils.isEmpty(binding.playerLastNameTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please player's last name", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.playerAdlRatingTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please player's ADL rating", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.playerEmailTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please player's email address", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.playerCardNumberTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please player's card number", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.playerPhoneTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please player's phone number", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.streetAddressTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please enter your street address", Snackbar.LENGTH_SHORT)
                    .show()

//                TextUtils.isEmpty(binding.addressLine2TextField.editText!!.text) -> Snackbar
//                    .make(binding.root, "Please enter your address line 2", Snackbar.LENGTH_SHORT)
//                    .show()

                TextUtils.isEmpty(binding.cityTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please enter your City", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.stateTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please enter your State", Snackbar.LENGTH_SHORT)
                    .show()

                TextUtils.isEmpty(binding.zipTextField.editText!!.text) -> Snackbar
                    .make(binding.root, "Please enter your zip code", Snackbar.LENGTH_SHORT)
                    .show()

                // TODO: checks for player card number(16 digits), both adl ratings(1-25) and zip(5 digits)
                (binding.playerCardNumberTextField.editText!!.text.toString().length != 16
                        || binding.captainCardNumberTextField.editText!!.text.toString().length != 16) -> Snackbar
                    .make(binding.root, "Card number has to be 16 digits", Snackbar.LENGTH_SHORT)
                    .show()


                binding.zipTextField.editText!!.text.toString().length != 5 -> Snackbar
                    .make(binding.root, "Zip has to be 5 digits", Snackbar.LENGTH_SHORT)
                    .show()

                binding.captainAdlRatingTextField.editText!!.text.toString().toInt() > 25 -> Snackbar
                    .make(binding.root, "ADL rating has to be between 1 and 25", Snackbar.LENGTH_SHORT)
                    .show()

                binding.playerAdlRatingTextField.editText!!.text.toString().toInt() > 25 -> Snackbar
                    .make(binding.root, "ADL rating has to be between 1 and 25", Snackbar.LENGTH_SHORT)
                    .show()
                // TODO: check for empty dropdown

                else -> {
                    // Add code for successful submission




                    // Save form values to the viewModel
                    val newForm = FormEntries(
                        binding.adlTeamNameTextField.editText!!.text.toString(),
                        binding.captainFirstNameTextField.editText!!.text.toString(),
                        binding.captainMiddleNameTextField.editText!!.text.toString(),
                        binding.captainLastNameTextField.editText!!.text.toString(),
                        binding.captainAdlRatingTextField.editText!!.text.toString(),
                        binding.captainEmailTextField.editText!!.text.toString(),
                        binding.captainCardNumberTextField.editText!!.text.toString(),
                        binding.captainPhoneTextField.editText!!.text.toString(),
                        binding.playerFirstNameTextField.editText!!.text.toString(),
                        binding.playerMiddleNameTextField.editText!!.text.toString(),
                        binding.playerLastNameTextField.editText!!.text.toString(),
                        binding.playerAdlRatingTextField.editText!!.text.toString(),
                        binding.playerEmailTextField.editText!!.text.toString(),
                        binding.playerPhoneTextField.editText!!.text.toString(),
                        binding.playerCardNumberTextField.editText!!.text.toString(),
                        binding.firstChoiceNightTextField.editText!!.text.toString(),
                        binding.secondChoiceNightTextField.editText!!.text.toString(),
                        binding.streetAddressTextField.editText!!.text.toString(),
                        binding.addressLine2TextField.editText!!.text.toString(),
                        binding.cityTextField.editText!!.text.toString(),
                        binding.stateTextField.editText!!.text.toString(),
                        binding.zipTextField.editText!!.text.toString(),
                    )
                    viewModel.setForm(newForm)
                    findNavController().navigate(R.id.action_fillPdfFragment_to_previewFragment)
                }
            }
        }

        return binding.root
    }
}