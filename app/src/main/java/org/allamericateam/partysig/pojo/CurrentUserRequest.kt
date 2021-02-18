package org.allamericateam.partysig.pojo

import com.google.gson.annotations.SerializedName

data class CurrentUserRequest(
    var query: String = "query {\n  currentUser {\n    name\n    email\n    eid\n    role\n    organizations {\n      eid\n      name\n      slug\n      casts {\n        eid\n        name\n      }\n    }\n  }\n}"
)