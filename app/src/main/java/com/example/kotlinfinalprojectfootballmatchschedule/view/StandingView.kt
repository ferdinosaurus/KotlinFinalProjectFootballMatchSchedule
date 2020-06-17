package com.example.kotlinfinalprojectfootballmatchschedule.view

import com.example.kotlinfinalprojectfootballmatchschedule.model.Standing


interface StandingView{
    fun showLoading()
    fun hideLoading()
    fun showNoStanding()
    fun showEvent(data: List<Standing>)
}