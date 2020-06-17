package com.example.kotlinfinalprojectfootballmatchschedule.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinfinalprojectfootballmatchschedule.database.model.FavoriteModel
import com.example.kotlinfinalprojectfootballmatchschedule.presenter.FavoritePresenter
import com.example.kotlinfinalprojectfootballmatchschedule.ui.FavoriteUI
import com.example.kotlinfinalprojectfootballmatchschedule.view.FavoriteView
import org.jetbrains.anko.setContentView

class FavoriteActivity : AppCompatActivity() ,FavoriteView{

    private lateinit var favoriteUI: FavoriteUI
    private lateinit var favoritePresenter: FavoritePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_favorite)
        favoriteUI = FavoriteUI(this)
        favoriteUI.setContentView(this)
        init()
        favoritePresenter.getAllFavorite()
    }

    private fun init(){
        favoritePresenter = FavoritePresenter(this,this)
    }
    override fun showLoading() {
        favoriteUI.showLoading()
    }

    override fun hideLoading() {
        favoriteUI.hideLoading()
    }

    override fun showNoFavorite() {
        favoriteUI.showNoFavorite()
    }

    override fun showFavorite(data: List<FavoriteModel>) {
        favoriteUI.showFavorite(data)
    }

}
