package org.allamericateam.partysig.models

data class FormEntries(
        val teamName: String,
        val captainFirstName: String,
        val captainMiddleName: String = "",
        val captainLastName: String,
        val captainAdlRating: String,
        val captainEmailAddress: String,
        val captainCardNumber: String,
        val captainPhone: String,
        val playerFirstName: String,
        val playerMiddleName: String = "",
        val playerLastName: String,
        val playerAdlRating: String,
        val playerEmailAddress: String,
        val playerPhone: String,
        val playerCardNumber: String,
        val firstChoiceNight: String,
        val secondChoiceNight: String,
        val streetAddress: String,
        val streetAddress2: String,
        val city: String,
        val state: String,
        val zip: String
)