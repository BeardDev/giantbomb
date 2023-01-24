package com.nik.smartapps.screen.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.nik.smartapps.databinding.FragmentWebBinding
import com.nik.smartapps.screen.main.MainViewModel

class WebFragment : Fragment() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = FragmentWebBinding.inflate(inflater, container, false).apply {
        webView.loadUrl(viewModel.url)
    }.root
}