package com.rafflypohan.isyaratku.ui.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.rafflypohan.isyaratku.R
import com.rafflypohan.isyaratku.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var profileBinding: ActivityProfileBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(profileBinding.root)

        setSupportActionBar(profileBinding.toolbar)
        profileBinding.toolbar.setNavigationIconTint(getColor(R.color.black))

        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}