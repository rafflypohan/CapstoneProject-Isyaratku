package com.rafflypohan.isyaratku.ui.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.rafflypohan.isyaratku.R
import com.rafflypohan.isyaratku.databinding.FragmentVoiceBinding

class VoiceFragment : Fragment() {
    private lateinit var voiceBinding: FragmentVoiceBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        openVoiceAssistant()
        voiceBinding = FragmentVoiceBinding.inflate(inflater, container, false)
        return voiceBinding.root
    }

    private fun openVoiceAssistant() {
        resultLauncher()

        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, "in_ID")
            putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something")
        }

        resultLauncher().launch(intent)
    }

    private fun resultLauncher(): ActivityResultLauncher<Intent> {
        return registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK){
                val data = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                voiceBinding.tvVoiceResult.text = data?.get(0).toString()
            }
        }
    }
}