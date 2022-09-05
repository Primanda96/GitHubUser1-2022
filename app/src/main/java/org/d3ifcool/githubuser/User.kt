package org.d3ifcool.githubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name: String? = null,
    var username: String? = null,
    var avatar:Int? = 0,
    var company: String? = null,
    var location: String? = null,
    var repository: String? = null,
    var follower: String? = null,
    var following: String? = null
) : Parcelable
