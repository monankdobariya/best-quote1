package com.musict.shayarihelper

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText

class LoginpageActivity : AppCompatActivity() {

    lateinit var cardlogin: CardView
    lateinit var edtusename: TextInputEditText
    lateinit var edtpassword: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.batali)
        }

        initview()
    }

    private fun initview() {
        cardlogin = findViewById(R.id.cardlogin)
        edtusename = findViewById(R.id.edtusename)
        edtpassword = findViewById(R.id.edtpassword)

        cardlogin.setOnClickListener {
            val username: String
            val password: String
            username = edtusename.text.toString()
            password = edtpassword.text.toString()

            if (username.isEmpty()) {
                Toast.makeText(
                    this@LoginpageActivity,
                    "Please enter your username",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (password.isEmpty())
                {
                    Toast.makeText(this@LoginpageActivity, "Please enter your password", Toast.LENGTH_SHORT).show()
                } else
                {
                    val i = Intent(this@LoginpageActivity, MainActivity::class.java)
                    startActivity(i)
                }
            }
        }
    }
}