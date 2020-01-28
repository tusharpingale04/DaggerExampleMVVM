package com.tushar.dagger22example.models

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class User(
    @SerializedName("address")
    var address: Address? = Address(),
    @SerializedName("company")
    var company: Company? = Company(),
    @SerializedName("email")
    var email: String? = "",
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("phone")
    var phone: String? = "",
    @SerializedName("username")
    var username: String? = "",
    @SerializedName("website")
    var website: String? = ""
) : Parcelable