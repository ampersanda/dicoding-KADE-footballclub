package com.ampersanda.footballclub

import android.os.Parcel
import android.os.Parcelable

data class FootballClub(val name: String, val image: Int, val description: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readInt(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeInt(image)
        writeString(description)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<FootballClub> = object : Parcelable.Creator<FootballClub> {
            override fun createFromParcel(source: Parcel): FootballClub = FootballClub(source)
            override fun newArray(size: Int): Array<FootballClub?> = arrayOfNulls(size)
        }
    }
}
