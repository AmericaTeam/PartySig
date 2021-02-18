package org.allamericateam.partysig.pojo

data class EtchEsignRequest(
        var query : String,
        var variables : EtchEsignVariablesObject
)

data class EtchEsignVariablesObject(
        var name : String,
        var isDraft : Boolean,
        var istest : Boolean,
        var signatureEmailSubject : String,
        var signatureEmailBody : String,
        var signatureProvider : String,
        var signaturePageOptions : SignaturePageOptions,
        var files : Array<EtchEsignVariablesFiles>,
        var signers : Signers,
        var data : EtchEsignData

) {

    data class SignaturePageOptions(
            var title : String,
            var description : String,
            var style : PageOptionStyle
    ){
        data class PageOptionStyle(
                var successColor : String,
                var infoColor : String
        )

    }

    data class EtchEsignVariablesFiles(
            var id : String,
            var castEid : String
    )

    data class Signers(
            var id : String,
            var name : String,
            var email : String,
            var fields : Array<SignersFields>,
            var signerType : String,
            var redirectURL : String,
            var enableEmails : Array<String>
    ) {
        data class SignersFields(
                var fileId : String,
                var fieldId : String
        )
    }

    data class EtchEsignData(
            var payloads : String
    )


}

