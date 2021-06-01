package com.rafflypohan.isyaratku.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.rafflypohan.isyaratku.R
import com.rafflypohan.isyaratku.databinding.FragmentTextBinding


class TextFragment : Fragment() {
    private lateinit var textBinding: FragmentTextBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        textBinding = FragmentTextBinding.inflate(inflater, container, false)
        return textBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(textBinding){
            etTranslate.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    isDisplayClearText(true)
                }

                override fun afterTextChanged(s: Editable?) {

                }

            })
            clearText.setOnClickListener {
                etTranslate.text.clear()
            }
        }

    }

    private fun isDisplayClearText(state: Boolean){
        with(textBinding.clearText){
            visibility = if (state) View.VISIBLE
            else View.GONE
        }
    }
}