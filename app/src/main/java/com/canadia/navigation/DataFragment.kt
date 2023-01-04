package com.canadia.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.navigation.fragment.findNavController

class DataFragment : Fragment() {
    private lateinit var webView: WebView
    private val URL = "https://www.google.com"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=  inflater.inflate(R.layout.fragment_data, container, false)
//        val button = view.findViewById<Button>(R.id.button1)
//
//        button.setOnClickListener {
//            findNavController().navigate(R.id.action_dataFragment_to_homeFragment)
//        }
//        return view
        webView = view.findViewById(R.id.webview)
        webView.apply { loadUrl(URL)
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }

        return view
    }

}