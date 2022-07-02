package com.example.findaim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.findaim.databinding.ActivityRegisterPageBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterPage : AppCompatActivity() {

    private lateinit var bindingRegisterPageBinding: ActivityRegisterPageBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingRegisterPageBinding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(bindingRegisterPageBinding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        bindingRegisterPageBinding.btnRegister.setOnClickListener {
            val email = bindingRegisterPageBinding.emailEt.text.toString()
            val pass = bindingRegisterPageBinding.passET.text.toString()
            val confirmPass = bindingRegisterPageBinding.confirmPassEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, LoginPage::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }

        bindingRegisterPageBinding.tbLoginHere.setOnClickListener {
            startActivity(Intent(this,LoginPage::class.java))
            finish()
        }
    }
}