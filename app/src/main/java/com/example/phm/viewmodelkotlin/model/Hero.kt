package com.example.phm.viewmodelkotlin.model
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName



data class Hero(
    @SerializedName("name") var name: String?,
    @SerializedName("realname") var realName: String?,
    @SerializedName("team") var team: String?,
    @SerializedName("firstappearance") var firstAppearance: String?,
    @SerializedName("createdby") var createdBy: String?,
    @SerializedName("publisher") var publisher: String?,
    @SerializedName("imageurl") var imageUrl: String?,
    @SerializedName("bio") var bio: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(realName)
        parcel.writeString(team)
        parcel.writeString(firstAppearance)
        parcel.writeString(createdBy)
        parcel.writeString(publisher)
        parcel.writeString(imageUrl)
        parcel.writeString(bio)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hero> {
        override fun createFromParcel(parcel: Parcel): Hero {
            return Hero(parcel)
        }

        override fun newArray(size: Int): Array<Hero?> {
            return arrayOfNulls(size)
        }
    }
}