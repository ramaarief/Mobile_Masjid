package com.example.tugasmasjid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_tagline.*
import kotlinx.android.synthetic.main.activity_update_tagline.*
import org.json.JSONArray
import org.json.JSONObject

class update_tagline : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_tagline)

        val context = this

        simpan.setOnClickListener{

            var data_isi :String = data1.text.toString()

            postkeserver(data_isi)

            val intent = Intent(context,TaglineActivity::class.java)
            startActivity(intent)

        }
    }

    fun postkeserver(data1:String)
    {
        AndroidNetworking.post("http://192.168.1.11/masjid/proses-tagline.php")
            .addBodyParameter("isi_tagline", data1)
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
