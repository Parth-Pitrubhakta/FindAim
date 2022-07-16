package com.example.findaim.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.findaim.R
import com.example.findaim.databinding.FragmentJobDetailsBinding

class JobDetailsFragment : Fragment() {

    private var binding: FragmentJobDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val fragmentbinding = FragmentJobDetailsBinding.inflate(inflater,container,false)
        binding = fragmentbinding
        return fragmentbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            jobFragment = this@JobDetailsFragment
        }

        binding!!.backbutton.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }
}