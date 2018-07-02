package com.example.phm.viewmodelkotlin

import android.app.Application
import android.content.Context

class MainApp: Application() {

    private var mContext: Context? = null

    override fun onCreate() {
        super.onCreate()

        mContext = applicationContext

    }

    fun getContext(): Context? {
        return mContext
    }



}