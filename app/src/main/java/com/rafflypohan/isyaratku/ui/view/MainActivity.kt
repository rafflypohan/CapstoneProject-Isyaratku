package com.rafflypohan.isyaratku.ui.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.speech.RecognizerIntent
import android.speech.tts.Voice
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.commit
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.rafflypohan.isyaratku.R
import com.rafflypohan.isyaratku.databinding.ActivityMainBinding
import com.rafflypohan.isyaratku.databinding.ContentHomeBinding
import com.rafflypohan.isyaratku.ui.fragment.CameraFragment
import com.rafflypohan.isyaratku.ui.fragment.TextFragment
import com.rafflypohan.isyaratku.ui.fragment.VoiceFragment
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var contentHomeBinding: ContentHomeBinding

    companion object {
        private const val REQUEST_SPEECH = 102
        private const val REQUEST_CAMERA = 103
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setSupportActionBar(mainBinding.toolbar)

        mainBinding.ivProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        bottomNavigationConfig()
    }

    private fun bottomNavigationConfig() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_text, R.id.nav_voice, R.id.nav_camera
        ))

        setupActionBarWithNavController(navController, appBarConfiguration)
        mainBinding.bottomNav.setupWithNavController(navController)
    }

    private fun bottomNavigationConfiggggg() {
        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK){
                val data = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)

            }
        }
        mainBinding.bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_text -> {
                    supportFragmentManager.commit {
                        addToBackStack(null)
                        replace(R.id.nav_host_fragment, TextFragment(), TextFragment::class.java.simpleName)
                    }
                    true
                }
                R.id.nav_voice -> {
//                    val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
//                        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
//                        putExtra(RecognizerIntent.EXTRA_LANGUAGE, "in_ID")
//                        putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something")
//                    }
//                    resultLauncher.launch(intent)

                    supportFragmentManager.commit {
                        addToBackStack(null)
                        replace(R.id.nav_host_fragment, VoiceFragment(), VoiceFragment::class.java.simpleName)
                    }

                    true
                }
                R.id.nav_camera -> {
//                    startActivity(Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA))

                    supportFragmentManager.commit {
                        addToBackStack(null)
                        replace(R.id.nav_host_fragment, CameraFragment(), CameraFragment::class.java.simpleName)
                    }

                    true
                }
                else -> false
            }
        }


        //        with(homeBinding){
//            ibText.setOnClickListener {
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//                    ibText.setColorFilter(getColor(R.color.green))
//                }
//            }
//
//            ibVoice.setOnClickListener {
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//                    ibVoice.setColorFilter(getColor(R.color.green))
//                }
//                startActivity(Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
//                    putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
//                })
//            }
//
//            ibCamera.setOnClickListener {
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//                    ibCamera.setColorFilter(getColor(R.color.green))
//                }
//                startActivity(Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA))
//            }

//        }
    }
}