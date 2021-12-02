package com.fatherofapps.androidbase.base.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.fatherofapps.androidbase.R

class ConfirmDialog constructor(
    context: Context,
    private val callback: ConfirmCallback?,
    private val title: String,
    private val message: String?,
    private val positiveButtonTitle: String,
    private val negativeButtonTitle: String
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_confirm)

        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        tvTitle.text = title

        message?.let {
            val tvContent = findViewById<TextView>(R.id.tvContent)
            tvContent.visibility = View.VISIBLE
            tvContent.text = message
        }

        val btnNegative = findViewById<Button>(R.id.btnNegative)
        btnNegative.text = negativeButtonTitle
        btnNegative.setOnClickListener {
            callback?.negativeAction()
            dismiss()
        }

        val btnPositive = findViewById<Button>(R.id.btnPositive)
        btnPositive.text = positiveButtonTitle
        btnPositive.setOnClickListener {
            callback?.positiveAction()
            dismiss()
        }

    }

    interface ConfirmCallback {
        fun negativeAction()
        fun positiveAction()
    }
}