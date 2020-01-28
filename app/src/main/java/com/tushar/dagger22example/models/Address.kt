package com.tushar.dagger22example.models

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Address(
    @SerializedName("city")
    var city: String? = "",
    @SerializedName("geo")
    var geo: Geo? = Geo(),
    @SerializedName("street")
    var street: String? = "",
    @SerializedName("suite")
    var suite: String? = "",
    @SerializedName("zipcode")
    var zipcode: String? = ""
) : Parcelable