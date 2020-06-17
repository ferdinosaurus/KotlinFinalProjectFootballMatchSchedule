package com.example.kotlinfinalprojectfootballmatchschedule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinfinalprojectfootballmatchschedule.R
import com.example.kotlinfinalprojectfootballmatchschedule.api.ApiRepository
import com.example.kotlinfinalprojectfootballmatchschedule.model.LeagueParcelable
import com.example.kotlinfinalprojectfootballmatchschedule.model.Standing
import com.example.kotlinfinalprojectfootballmatchschedule.presenter.StandingPresenter
import com.example.kotlinfinalprojectfootballmatchschedule.view.StandingView
import com.google.gson.Gson

class StandingActivity : AppCompatActivity(),StandingView{

    private lateinit var leagueParcelable: LeagueParcelable
    private lateinit var presenter: StandingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standing)
        leagueParcelable= intent.getParcelableExtra("ExtraLeague")
        presenter = StandingPresenter(this, ApiRepository(), Gson())
        presenter.getStanding(leagueParcelable.id)
    }

    override fun showLoading() {
        Log.d("getStandings","showLoading")
    }

    override fun hideLoading() {
        Log.d("getStandings","hideLoading")
    }

    override fun showNoStanding() {
        Log.d("getStandings","showNoStanding")
    }

    override fun showEvent(data: List<Standing>) {
        Log.d("getStandings",data.toString())
    }
}
