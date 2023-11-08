package com.example.farmersapp.models

class ScreenItem(var mTitle: String, var mDescription: String, var mScreenImg: Int) {
    var Title: String
    var Description: String
    var sScreenImg: Int

    init {
        Title = mTitle
        Description = mDescription
        sScreenImg = mScreenImg
    }
    fun setmTitle(title: String) {
        Title = title
    }

    fun setmDescription(description: String) {
        Description = description
    }

    fun setmScreenImg(screenImg: Int) {
        sScreenImg = screenImg
    }

    fun getmTitle(): String {
        return Title
    }

    fun getmDescription(): String {
        return Description
    }

    fun getmScreenImg(): Int {
        return sScreenImg
    }
}