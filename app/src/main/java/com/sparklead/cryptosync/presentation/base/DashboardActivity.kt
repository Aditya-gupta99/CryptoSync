package com.sparklead.cryptosync.presentation.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sparklead.cryptosync.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }
}