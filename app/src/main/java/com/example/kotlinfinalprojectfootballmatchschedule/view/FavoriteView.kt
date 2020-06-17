package com.example.kotlinfinalprojectfootballmatchschedule.view

import com.example.kotlinfinalprojectfootballmatchschedule.database.model.FavoriteModel


interface FavoriteView{
    fun showLoading()
    fun hideLoading()
    fun showNoFavorite()
    fun showFavorite(data: List<FavoriteModel>)
}