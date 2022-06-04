package com.example.findaim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        val username = findViewById<TextView>(R.id.et_username_registerpg)
        val email = findViewById<TextView>(R.id.et_email_registerpg)
        val password = findViewById<TextView>(R.id.et_password_registerpg)
        val confirmpassword = findViewById<TextView>(R.id.et_confirmpassword_registerpg)
        val btnregister = findViewById<Button>(R.id.btn_register)
        val btnloginhere = findViewById<TextView>(R.id.tb_LoginHere)

        btnregister.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        btnloginhere.setOnClickListener {
            startActivity(Intent(this,LoginPage::class.java))
            finish()
        }
    }
}