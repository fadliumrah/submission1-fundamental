package com.fadli.githubappuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(

    var name: String,
    var userName: String,
    var avatar: Int,
    var company : String,
    var location : String,
    var following : String,
    var follower : String,
    var repository : String
): Parcelable
