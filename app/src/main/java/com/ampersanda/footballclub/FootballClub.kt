package com.ampersanda.footballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootballClub(val name: String, val image: Int, val description: String) : Parcelable