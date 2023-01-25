package com.nik.smartapps.screen.web

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.nik.smartapps.databinding.FragmentWebBinding

class WebFragment : Fragment() {
    private val webViewModel by viewModels<WebViewModel>()
    private lateinit var webview: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = FragmentWebBinding.inflate(inflater, container, false).apply {
        if (savedInstanceState == null)
        {
            webView.loadUrl(webViewModel.url)
        }
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.databaseEnabled = true
        webView.settings.setAppCacheEnabled(true)

        webView.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                webView.goBack()
                return@OnKeyListener true
            } else {
                findNavController().navigate(WebFragmentDirections.actionWebFragmentToMainFragment())
            }
            false
        })

    }.root


}