package com.example.kotlinfinalprojectfootballmatchschedule.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueParcelable (val id: String?,val name: String?, val image: Int?,val desc: String?) : Parcelable