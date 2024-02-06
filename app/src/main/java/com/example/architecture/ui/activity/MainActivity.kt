package com.example.architecture.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.architecture.R
import com.example.architecture.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}