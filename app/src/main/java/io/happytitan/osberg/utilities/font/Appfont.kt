package io.happytitan.osberg.utilities.font

import android.content.Context
import android.graphics.Typeface

class AppFont(private val context: Context) {

    val boldFont: Typeface
    val regularFont: Typeface

    init {
        this.boldFont = initialiseType(BOLD)
        this.regularFont = initialiseType(REGULAR)
    }

    private fun initialiseType(type: String): Typeface {
        return Typeface.createFromAsset(context.assets, type)
    }



    companion object {
        private val BOLD = "RobotoCondensed-Bold.ttf"
        private val REGULAR = "Roboto-Regular.ttf"
    }
}
