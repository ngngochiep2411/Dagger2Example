package com.example.dagger2example.model

import com.google.gson.annotations.SerializedName

data class Profile(

    @SerializedName("login")
    val login: String,

    @SerializedName("avatar_url")
    val avtURL: String
)