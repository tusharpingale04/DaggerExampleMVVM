package com.tushar.dagger22example.models

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Geo(
    @SerializedName("lat")
    var lat: String? = "",
    @SerializedName("lng")
    var lng: String? = ""
) : Parcelable