package com.fatherofapps.androidbase.base.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.text.HtmlCompat
import com.fatherofapps.androidbase.R

class NotifyDialog (
    context: Context,
    private val title: String,
    private val message: String,
    private val textButton: String? = null
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_notify)

        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        tvTitle.text = title

        val tvContent = findViewById<TextView>(R.id.tvContent)
        tvContent.text = HtmlCompat.fromHtml(message, HtmlCompat.FROM_HTML_MODE_LEGACY)

        val btnOK = findViewById<AppCompatButton>(R.id.btnOK)
        textButton?.let {
            btnOK.text = textButton
        }
        btnOK.setOnClickListener {
            dismiss()
        }

    }

}