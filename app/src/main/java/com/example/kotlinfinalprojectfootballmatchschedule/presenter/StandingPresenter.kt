package com.example.kotlinfinalprojectfootballmatchschedule.presenter

import com.example.kotlinfinalprojectfootballmatchschedule.api.ApiRepository
import com.example.kotlinfinalprojectfootballmatchschedule.api.TheSportDBApi
import com.example.kotlinfinalprojectfootballmatchschedule.model.StandingResponse
import com.example.kotlinfinalprojectfootballmatchschedule.view.StandingView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class StandingPresenter(private val view: StandingView,
                        private val apiRepository: ApiRepository,
                        private val gson: Gson) {
    fun getStanding(leagueId: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTable(leagueId)),
                StandingResponse::class.java
            )
            uiThread {
                if(data.standings!=null){
                    view.showEvent(data.standings)
                }else{
                    view.showNoStanding()
                }
                view.hideLoading()
            }
        }
    }

}