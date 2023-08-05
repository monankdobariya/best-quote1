package com.musict.shayarihelper

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class WelcomeActivity : AppCompatActivity() {

    lateinit var cardcontinue: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.batali)
        }

        initview()
    }

    private fun initview() {
        cardcontinue = findViewById(R.id.cardcontinue)

        cardcontinue.setOnClickListener(View.OnClickListener {
            val i = Intent(this, Welcompage2Activity::class.java)
            startActivity(i)
        })

    }
}