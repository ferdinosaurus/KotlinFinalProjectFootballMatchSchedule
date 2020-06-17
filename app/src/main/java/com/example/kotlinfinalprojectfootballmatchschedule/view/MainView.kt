package com.example.kotlinfinalprojectfootballmatchschedule.view

import com.example.kotlinfinalprojectfootballmatchschedule.model.LeagueParcelable


interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showLeagueList(data: List<LeagueParcelable>)


}