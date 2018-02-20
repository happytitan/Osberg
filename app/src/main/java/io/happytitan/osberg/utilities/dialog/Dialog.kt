package io.happytitan.osberg.utilities.dialog

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import io.happytitan.osberg.R
import io.happytitan.osberg.utilities.font.AppFont

class MsgDialog private constructor(context: Context) : android.app.Dialog(context), View.OnClickListener {

    fun show(msg: String): MsgDialog {

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        setContentView(R.layout.dialog)
        window!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

        val body = findViewById<TextView>(R.id.showDescription) as TextView
        val positive = findViewById<Button>(POSITIVE) as Button

        val appFont = AppFont(context)
        body.typeface = appFont.regularFont
        positive.typeface = appFont.boldFont

        positive.setOnTouchListener(buttonTouch(positive))
        positive.setOnClickListener(this)
        body.text = msg

        return this
    }

    private fun buttonTouch(button: Button): View.OnTouchListener {
        return View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_MOVE) {
                button.setBackgroundResource(R.drawable.button_border_pressed)
            } else {
                button.setBackgroundResource(R.drawable.button_border)
            }
            false
        }
    }

    override fun onClick(v: View) {
        dismiss()
    }

    companion object {

        val POSITIVE = R.id.positiveButton

        fun with(context: Context, msg: String): MsgDialog {
            return MsgDialog(context).show(msg)
        }
    }
}
