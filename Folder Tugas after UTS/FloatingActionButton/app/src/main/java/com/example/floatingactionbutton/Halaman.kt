package com.example.floatingactionbutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_halaman.*

class Halaman : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman)

        val context = this

        back.setOnClickListener{
            val intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
