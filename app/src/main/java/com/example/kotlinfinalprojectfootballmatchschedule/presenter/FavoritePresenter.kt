package com.example.kotlinfinalprojectfootballmatchschedule.presenter

import android.app.Activity
import com.example.kotlinfinalprojectfootballmatchschedule.database.dao.FavoriteDao
import com.example.kotlinfinalprojectfootballmatchschedule.database.model.FavoriteModel
import com.example.kotlinfinalprojectfootballmatchschedule.view.FavoriteView

class FavoritePresenter(activity: Activity, private val view: FavoriteView) {
    private var favoriteDao:FavoriteDao = FavoriteDao(activity)
    fun getAllFavorite() {
        view.showLoading()
        val favoriteModelList:List<FavoriteModel> =  favoriteDao.getAll()
        view.showFavorite(favoriteModelList)
        view.hideLoading()
    }
}