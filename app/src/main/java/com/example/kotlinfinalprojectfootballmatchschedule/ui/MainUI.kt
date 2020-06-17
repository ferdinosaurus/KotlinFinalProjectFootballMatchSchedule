package com.example.kotlinfinalprojectfootballmatchschedule.ui

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfinalprojectfootballmatchschedule.activity.ChooseActivity
import com.example.kotlinfinalprojectfootballmatchschedule.activity.EventActivity
import com.example.kotlinfinalprojectfootballmatchschedule.activity.FavoriteActivity
import com.example.kotlinfinalprojectfootballmatchschedule.activity.MainActivity
import com.example.kotlinfinalprojectfootballmatchschedule.adapter.LeagueAdapter
import com.example.kotlinfinalprojectfootballmatchschedule.model.LeagueParcelable
import com.example.kotlinfinalprojectfootballmatchschedule.view.MainView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainUI (context: Context): AnkoComponent<MainActivity> , MainView {

    private val context = context


    private var leagues: MutableList<LeagueParcelable> = mutableListOf()
    private lateinit var rvLeague:RecyclerView

    private lateinit var progressBar: ProgressBar

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            padding = dip(16)

            lparams(matchParent, matchParent)
            button {
                text = "my favorite"
                onClick {
                    context.startActivity(Intent(context,FavoriteActivity::class.java))
                }
            }.lparams(matchParent, wrapContent)

            relativeLayout {

                lparams(matchParent, matchParent)
                rvLeague = recyclerView {

                    lparams(matchParent, matchParent)
                    layoutManager = GridLayoutManager(context, 2)
                    adapter = LeagueAdapter(context, leagues) {
                        startActivity<EventActivity>("ExtraLeague" to it)
                    }

                }
                progressBar = progressBar {
                }.lparams{
                    centerHorizontally()
                }
            }

        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showLeagueList(data: List<LeagueParcelable>) {
        rvLeague.adapter = LeagueAdapter(context, data as MutableList<LeagueParcelable>) {
            context.startActivity<ChooseActivity>("ExtraLeague" to it)
        }
    }
}