package com.example.findaim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val newsLogo = findViewById<ImageView>(R.id.IV_splashscreen)
        newsLogo.animate().setDuration(3000).alpha(1f).withEndAction {
            val i = Intent(this, LoginPage::class.java)
            startActivity(i)
            finish()
        }
    }
}