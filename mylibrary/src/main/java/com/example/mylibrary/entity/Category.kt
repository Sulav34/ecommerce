package com.example.mylibrary.entity

import android.os.Parcel
import android.os.Parcelable

data class Category (
    var _id: String? = null,
    val categoryName: String? = null,
    val photo: String? = null,
    val categoryType: String? = null,
    val categoryRating: String? = null,
    val categoryPrice: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(categoryName)
        parcel.writeString(photo)
        parcel.writeString(categoryType)
        parcel.writeString(categoryRating)
        parcel.writeValue(categoryPrice)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Category> {
        override fun createFromParcel(parcel: Parcel): Category {
            return Category(parcel)
        }

        override fun newArray(size: Int): Array<Category?> {
            return arrayOfNulls(size)
        }
    }
}
