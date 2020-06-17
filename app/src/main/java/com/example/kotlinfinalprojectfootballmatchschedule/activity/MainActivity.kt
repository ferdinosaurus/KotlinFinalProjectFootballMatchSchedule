package com.example.kotlinfinalprojectfootballmatchschedule.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinfinalprojectfootballmatchschedule.model.LeagueParcelable
import com.example.kotlinfinalprojectfootballmatchschedule.presenter.MainPresenter
import com.example.kotlinfinalprojectfootballmatchschedule.ui.MainUI
import com.example.kotlinfinalprojectfootballmatchschedule.view.MainView
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() , MainView {

    private lateinit var presenter: MainPresenter
    private lateinit var mainUI: MainUI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mainUI = MainUI(this)
        mainUI.setContentView(this)
        init()


    }

    private fun init(){
        presenter = MainPresenter(this,this)
        presenter.setupData()

    }

    override fun showLoading() {
        mainUI.showLoading()
    }

    override fun hideLoading() {
        mainUI.hideLoading()
    }

    override fun showLeagueList(data: List<LeagueParcelable>) {
        mainUI.showLeagueList(data)

    }

}
