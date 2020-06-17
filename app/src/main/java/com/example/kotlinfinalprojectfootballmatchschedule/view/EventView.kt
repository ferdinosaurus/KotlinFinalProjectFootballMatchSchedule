package com.example.kotlinfinalprojectfootballmatchschedule.view

import com.example.kotlinfinalprojectfootballmatchschedule.model.Event


interface EventView{
    fun showLoading()
    fun hideLoading()
    fun showNoEvent()
    fun showEvent(data: List<Event>)
}