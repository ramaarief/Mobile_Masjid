package com.example.tugasmasjid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this

        jamSholat.setOnClickListener{
            val intent = Intent(context,SholatActivity::class.java)
            startActivity(intent)
        }

        identitas.setOnClickListener{
            val intent = Intent(context,IdentitasActivity::class.java)
            startActivity(intent)
        }

        marquee.setOnClickListener{
            val intent = Intent(context,MarqueeActivity::class.java)
            startActivity(intent)
        }

        pengumuman.setOnClickListener{
            val intent = Intent(context,PengumumanActivity::class.java)
            startActivity(intent)
        }

        slideshow.setOnClickListener{
            val intent = Intent(context,SlideshowActivity::class.java)
            startActivity(intent)
        }

        tagline.setOnClickListener{
            val intent = Intent(context,TaglineActivity::class.java)
            startActivity(intent)
        }


    }
}
