package com.example.kotlinfinalprojectfootballmatchschedule.presenter

import com.example.kotlinfinalprojectfootballmatchschedule.api.ApiRepository
import com.example.kotlinfinalprojectfootballmatchschedule.api.TheSportDBApi
import com.example.kotlinfinalprojectfootballmatchschedule.model.EventResponse
import com.example.kotlinfinalprojectfootballmatchschedule.model.SearchEventResponse
import com.example.kotlinfinalprojectfootballmatchschedule.view.EventView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EventPresenter(private val view: EventView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson) {
    fun getNextEvent(leagueId: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNextEvent(leagueId)),
                EventResponse::class.java
            )
            uiThread {
                if(data.events!=null){
                    view.showEvent(data.events)
                }else{
                    view.showNoEvent()
                }
                view.hideLoading()
            }
        }
    }

    fun getPrevEvent(leagueId: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getPrevEvent(leagueId)),
                EventResponse::class.java
            )
            uiThread {
                if(data.events!=null){
                    view.showEvent(data.events)
                }else{
                    view.showNoEvent()
                }
                view.hideLoading()
            }
        }
    }

    fun getSearchEvent(textSearch: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getSearchEvent(textSearch)),
                SearchEventResponse::class.java
            )
            uiThread {
                if(data.event!=null){
                    view.showEvent(data.event)
                }else{
                    view.showNoEvent()
                }
                view.hideLoading()
            }
        }
    }





}