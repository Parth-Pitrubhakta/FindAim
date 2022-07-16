package com.example.findaim.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.findaim.R
import com.example.findaim.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth


class HomeFragment : Fragment() {

    private var binding : FragmentHomeBinding? = null
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val fragmentBinding = FragmentHomeBinding.inflate(inflater,  container,false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            homeFragment =this@HomeFragment
        }


        firebaseAuth = FirebaseAuth.getInstance()
        val currentUser = firebaseAuth.currentUser

        binding!!.tvNameMainpg.text = currentUser?.displayName

        Glide.with(this).load(currentUser?.photoUrl).into(binding!!.IbHomepageprofilephoto)

        binding!!.IbHomepageprofilephoto.setOnClickListener{
            findNavController().navigate(R.id.profileFragment)
        }

    }

    fun openLink(link: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(intent)
    }




}