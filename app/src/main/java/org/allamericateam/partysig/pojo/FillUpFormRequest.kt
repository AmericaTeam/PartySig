package org.allamericateam.partysig.pojo

data class FillUpFormRequest(
    var data: String,
    var fontSize: Int = 10,
    var textColor: String = "#a824e8",
    var title: String
)

data class Data(
    val Location: String,
    val captainCardNumber: String,
    val captainEmail: String,
    val captainName: CaptainName,
    val captainPhoneNumber: CaptainPhoneNumber,
    val captainRaiting: Int,
    val firstchoice: String,
    val secondchoice: String,
    val teamName: String,
    val teammateCardNumber: String,
    val teammateEmail: String,
    val teammateName: TeammateName,
    val teammatePhoneNumber: TeammatePhoneNumber,
    val teammateRaiting: Int
)

data class CaptainName(
    val firstName: String,
    val lastName: String,
    val mi: String
)

data class CaptainPhoneNumber(
    val baseRegion: String,
    val num: String,
    val region: String
)

data class TeammateName(
    val firstName: String,
    val lastName: String,
    val mi: String
)

data class TeammatePhoneNumber(
    val baseRegion: String,
    val num: String,
    val region: String
)