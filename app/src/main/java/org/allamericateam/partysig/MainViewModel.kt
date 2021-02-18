package org.allamericateam.partysig

import androidx.lifecycle.ViewModel
import org.allamericateam.partysig.models.FormEntries


class MainViewModel: ViewModel() {
    private var form: FormEntries? = null
    private var recipientNames: String? = null
    private var recipientEmails: String? = null

    fun getForm(): FormEntries? {
        return form
    }

    fun setForm(newForm: FormEntries) {
        form = newForm
    }

    fun getRecipientNames(): String? {
        return recipientNames
    }
    fun setRecipientNames(names: String) {
        recipientNames = names
    }

    fun getRecipientEmails(): String? {
        return recipientEmails
    }
    fun setRecipientEmails(emails: String) {
        recipientEmails = emails
    }
}