package com.tushar.dagger22example.models

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Company(
    @SerializedName("bs")
    var bs: String? = "",
    @SerializedName("catchPhrase")
    var catchPhrase: String? = "",
    @SerializedName("name")
    var name: String? = ""
) : Parcelable