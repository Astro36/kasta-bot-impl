package io.github.astro36.kastabotimpl

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class BotInterface(private val mContext: Context) {
    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }
}