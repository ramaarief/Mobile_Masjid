package com.example.tugasmasjid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_update_slideshow.*
import org.json.JSONArray

class update_slideshow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_slideshow)

        val context = this

        simpan.setOnClickListener{

            var data_judul :String = data1.text.toString()
            var data_url :String = data2.text.toString()

            postkeserver(data_judul, data_url)

            val intent = Intent(context,SlideshowActivity::class.java)
            startActivity(intent)

        }
    }

    fun postkeserver(data1:String, data2:String)
    {
        AndroidNetworking.post("http://192.168.1.11/masjid/proses-slideshow.php")
            .addBodyParameter("judul_slideshow", data1)
            .addBodyParameter("url_slideshow", data2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {

                }

                override fun onError(anError: ANError?) {

                }
            })
    }
}
