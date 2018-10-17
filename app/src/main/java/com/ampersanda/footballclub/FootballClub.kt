package com.ampersanda.footballclub

import android.os.Parcel
import android.os.Parcelable

data class FootballClub(val name : String, val image : Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt())

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<FootballClub> {
        override fun createFromParcel(parcel: Parcel): FootballClub {
            return FootballClub(parcel)
        }

        override fun newArray(size: Int): Array<FootballClub?> {
            return arrayOfNulls(size)
        }
    }
}
