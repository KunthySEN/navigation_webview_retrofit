package com.canadia.navigation

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val button = view.findViewById<Button>(R.id.button)
        val posts = view.findViewById<Button>(R.id.posts)
        val post = view.findViewById<Button>(R.id.post)

        val viewModel: MainActivityViewModel by viewModels()

        button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_dataFragment)

        }
        post.setOnClickListener{
            viewModel.getPost()
            viewModel.myResponse.observe(viewLifecycleOwner, Observer {
                Log.d(TAG, it.userId.toString())
                Log.d(TAG, it.id.toString())
                Log.d(TAG,it.body)
                Log.d(TAG,it.title)
            })
        }
        posts.setOnClickListener{
            viewModel.getPosts()
            viewModel.myResponseList.observe(viewLifecycleOwner, Observer {
                for (user in it) {
                    Log.d(TAG, user.body)
                    Log.d(TAG, user.title)
                    Log.d(TAG, user.id.toString())
                    Log.d(TAG, user.userId.toString())
                }
            })
        }
        return view
    }

}