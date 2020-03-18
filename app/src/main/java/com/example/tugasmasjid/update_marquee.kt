package com.example.tugasmasjid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_update_marquee.*
import org.json.JSONArray

class update_marquee : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_marquee)

        val context = this

        simpan.setOnClickListener{

            var data_marquee :String = data1.text.toString()

            postkeserver(data_marquee)

            val intent = Intent(context,MarqueeActivity::class.java)
            startActivity(intent)

        }
    }

    fun postkeserver(data1:String)
    {
        AndroidNetworking.post("http://192.168.1.11/masjid/proses-marquee.php")
            .addBodyParameter("isi_marquee", data1)
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
