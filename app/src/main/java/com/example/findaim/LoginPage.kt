package com.example.findaim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val forgotpassword = findViewById<TextView>(R.id.tb_forgotpassword)
        val btnregisterhere = findViewById<TextView>(R.id.tb_RegisterHere)
        val btnlogin = findViewById<Button>(R.id.btn_login)

        forgotpassword.setOnClickListener {
            startActivity(Intent(this,ForgotPasswordPage::class.java))
        }

        btnregisterhere.setOnClickListener {
            startActivity(Intent(this,RegisterPage::class.java))
            finish()
        }

        btnlogin.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}