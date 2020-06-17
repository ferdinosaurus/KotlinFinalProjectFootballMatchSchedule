package com.example.kotlinfinalprojectfootballmatchschedule.view

import com.example.kotlinfinalprojectfootballmatchschedule.model.Event
import com.example.kotlinfinalprojectfootballmatchschedule.model.Team

interface EventDetailView{
    fun showLoading()
    fun hideLoading()
    fun showNoEvent()
    fun showDetailEvent(data: Event)
    fun showDetailHome(data: Team)
    fun showDetailAway(data: Team)

}