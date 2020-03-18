package com.example.tugasmasjid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_update_sholat.*
import org.json.JSONArray

class update_sholat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_sholat)

        val context = this

        simpan.setOnClickListener{

            var data_dhuha :String = data1.text.toString()
            var data_shubuh :String = data2.text.toString()
            var data_dhuhur :String = data3.text.toString()
            var data_ashar :String = data4.text.toString()
            var data_maghrib :String = data5.text.toString()
            var data_isha :String = data6.text.toString()

            postkeserver(data_dhuha, data_shubuh, data_dhuhur, data_ashar, data_maghrib, data_isha )

            val intent = Intent(context,SholatActivity::class.java)
            startActivity(intent)

        }
    }

    fun postkeserver(data1:String, data2:String, data3:String, data4:String, data5:String, data6:String)
    {
        AndroidNetworking.post("http://192.168.1.11/masjid/proses-jadwal.php")
            .addBodyParameter("dhuha", data1)
            .addBodyParameter("shubuh", data2)
            .addBodyParameter("dhuhur", data3)
            .addBodyParameter("ashar", data4)
            .addBodyParameter("maghrib", data5)
            .addBodyParameter("isha", data6)
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
