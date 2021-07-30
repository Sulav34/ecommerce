package com.example.mylibrary.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    var ProductName: String? = null,
    var Price: Int? = null,
    var Size: String? = null,
    var Brand: String? = null
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var PId: Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
        PId = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(ProductName)
        parcel.writeValue(Price)
        parcel.writeString(Size)
        parcel.writeString(Brand)
        parcel.writeInt(PId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }


}