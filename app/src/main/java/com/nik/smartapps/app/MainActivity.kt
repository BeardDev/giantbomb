package com.nik.smartapps.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nik.smartapps.R
import com.nik.smartapps.screen.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}