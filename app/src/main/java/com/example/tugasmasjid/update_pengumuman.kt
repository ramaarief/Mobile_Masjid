package com.example.tugasmasjid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_update_pengumuman.*
import org.json.JSONArray

class update_pengumuman : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_pengumuman)

        val context = this

        simpan.setOnClickListener{

            var data_judul :String = data1.text.toString()
            var data_isi :String = data2.text.toString()
            var data_aktif :String = data2.text.toString()

            postkeserver(data_judul, data_isi, data_aktif)

            val intent = Intent(context,PengumumanActivity::class.java)
            startActivity(intent)

        }
    }

    fun postkeserver(data1:String, data2:String, data3:String)
    {
        AndroidNetworking.post("http://192.168.1.11/masjid/proses-pengumuman.php")
            .addBodyParameter("judul_pengumuman", data1)
            .addBodyParameter("isi_pengumuman", data2)
            .addBodyParameter("aktif", data3)
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
