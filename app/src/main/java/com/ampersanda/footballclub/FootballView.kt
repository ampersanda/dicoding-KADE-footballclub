package com.ampersanda.footballclub

import android.view.Gravity
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import org.jetbrains.anko.*

class FootballView : AnkoComponent<ViewGroup>{

    companion object {
        const val clubLogoId = 1
        const val clubNameId = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui){
        linearLayout {
            lparams(matchParent, wrapContent)
            padding = dip(16)
            verticalGravity = Gravity.CENTER_VERTICAL
            isClickable = true
            isFocusable = true
            background = ResourcesCompat.getDrawable(resources, R.drawable.ripple, null)

            imageView {
                id = clubLogoId
            }.lparams(width = dip(64), height = dip(64))

            textView {
                id = clubNameId
                textSize = 16f
            }.lparams(width = matchParent, height = wrapContent){
                marginStart = dip(16)
            }
        }
    }

}