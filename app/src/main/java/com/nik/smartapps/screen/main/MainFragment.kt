package com.nik.smartapps.screen.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import androidx.lifecycle.lifecycleScope
import com.nik.smartapps.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.nik.smartapps.R

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMainBinding.inflate(inflater, container, false).apply {
        lifecycleScope.launchWhenStarted{
            viewModel.start()
            viewModel.token.collect {
                if (it) {
                    navigateToWeb()
                }
            }
        }
    }.root

    private fun navigateToWeb() {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToWebFragment())
    }

    private fun startGame() {
        // TODO: Open a unique game
    }
}