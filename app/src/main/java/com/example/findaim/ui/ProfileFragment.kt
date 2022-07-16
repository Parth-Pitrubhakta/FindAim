package com.example.findaim.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.findaim.LoginPage
import com.example.findaim.R
import com.example.findaim.databinding.FragmentProfileBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var bindingProfileBinding: FragmentProfileBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(view.context, gso)

        firebaseAuth = FirebaseAuth.getInstance()
        val currentUser = firebaseAuth.currentUser

        bindingProfileBinding.username.text = currentUser?.displayName
        bindingProfileBinding.userid.text = currentUser?.email

        Glide
            .with(this)
            .load(currentUser?.photoUrl)
            .centerInside()
            .into(bindingProfileBinding.profilePhoto)

        bindingProfileBinding.logout.setOnClickListener{
            firebaseAuth.signOut()
            mGoogleSignInClient.signOut().addOnCompleteListener {
                Toast.makeText(view.context, "Logging Out", Toast.LENGTH_SHORT).show()
                startActivity(Intent(view.context, LoginPage::class.java))
                activity?.finish()
            }
        }

        bindingProfileBinding.backbutton.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        bindingProfileBinding = FragmentProfileBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return bindingProfileBinding.root
    }

}