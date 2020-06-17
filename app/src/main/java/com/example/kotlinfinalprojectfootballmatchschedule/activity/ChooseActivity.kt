package com.example.kotlinfinalprojectfootballmatchschedule.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.kotlinfinalprojectfootballmatchschedule.R
import com.example.kotlinfinalprojectfootballmatchschedule.activity.EventActivity
import com.example.kotlinfinalprojectfootballmatchschedule.model.LeagueParcelable
import kotlinx.android.synthetic.main.activity_choose.*
import org.jetbrains.anko.find

class ChooseActivity : AppCompatActivity() {

    private lateinit var leagueParcelable: LeagueParcelable
    private lateinit var btn_choose_events:Button
    private lateinit var btn_choose_standings:Button
    private lateinit var tv_choose_leagueName:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        init()
        setupData()
        setupListener()
    }

    private fun init(){

        leagueParcelable= intent.getParcelableExtra("ExtraLeague")
        btn_choose_events = findViewById(R.id.btn_choose_events) as Button
        btn_choose_standings = findViewById(R.id.btn_choose_standings) as Button
        tv_choose_leagueName = findViewById(R.id.tv_choose_leagueName) as TextView

    }

    private fun setupData(){
        tv_choose_leagueName.setText(leagueParcelable.name)
    }

    private fun setupListener(){
        btn_choose_events.setOnClickListener {
            val intent:Intent =Intent(this, EventActivity::class.java)
            intent.putExtra("ExtraLeague",leagueParcelable)
            startActivity(intent)
        }
    }
}
