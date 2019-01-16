package io.github.astro36.kastabotimpl

import android.content.Context
import android.webkit.WebView

class JsEngine(context: Context)  {
    private val mWebView: WebView = WebView(context)

    init {
        mWebView.setWillNotDraw(true)
        mWebView.settings.javaScriptEnabled = true
        mWebView.addJavascriptInterface(BotInterface(context), "Bot")
    }

    fun run(src: String) {
        mWebView.evaluateJavascript(src) {
            print(it)
        }
    }

    /** @see {@link https://stackoverflow.com/questions/17418503/destroy-webview-in-android} */
    fun stop() {
        mWebView.removeJavascriptInterface("Bot")
        mWebView.loadUrl("about:blank")
        mWebView.clearCache(true)
        mWebView.clearHistory()
        mWebView.removeAllViews()
        mWebView.destroy()
    }
}