package com.rafflypohan.isyaratku.ui.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.rafflypohan.isyaratku.R
import com.rafflypohan.isyaratku.databinding.FragmentCameraBinding

class CameraFragment : Fragment() {
  private lateinit var cameraBinding: FragmentCameraBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        openCamera()
        cameraBinding = FragmentCameraBinding.inflate(inflater, container, false)
        return cameraBinding.root
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun openCamera() {

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if ( result.resultCode == RESULT_OK){
                val videoUri: Uri? = result.data?.data
                cameraBinding.testVideoResult.setVideoURI(videoUri)
                cameraBinding.testVideoResult.start()
            }
        }

        val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE).also { takeVideo ->
            activity?.packageManager?.let {
                takeVideo.resolveActivity(it)
            }
        }

        resultLauncher.launch(intent)
    }

}