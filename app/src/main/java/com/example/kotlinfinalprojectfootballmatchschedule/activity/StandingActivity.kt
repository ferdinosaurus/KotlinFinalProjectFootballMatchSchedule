package com.example.kotlinfinalprojectfootballmatchschedule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinfinalprojectfootballmatchschedule.R
import com.example.kotlinfinalprojectfootballmatchschedule.model.Standing
import com.example.kotlinfinalprojectfootballmatchschedule.view.StandingView

class StandingActivity : AppCompatActivity(),StandingView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standing)
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun showNoStanding() {
        TODO("Not yet implemented")
    }

    override fun showEvent(data: List<Standing>) {
        TODO("Not yet implemented")
    }
}
