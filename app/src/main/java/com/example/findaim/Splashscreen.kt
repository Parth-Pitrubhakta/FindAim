package com.example.findaim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.google.firebase.auth.FirebaseAuth

class Splashscreen : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        firebaseAuth = FirebaseAuth.getInstance()
        val user = firebaseAuth.currentUser

        Handler(Looper.getMainLooper()).postDelayed({
            /** If user is not authenticated, send him to signInPage to authenticate first.
             * else send him to HomePage */
            if (user != null){
                val homepageintent = Intent(this,MainActivity::class.java)
                startActivity(homepageintent)
                finish()
            }else{
                val signInIntent = Intent(this, LoginPage::class.java)
                startActivity(signInIntent)
                finish()
            }

        }, 2000)

    }
}