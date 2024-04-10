package com.kkyume.android.todaytnotice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kkyume.android.todaytnotice.databinding.ActivityMainBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.ServerSocket
import java.net.Socket

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = OkHttpClient()

        val request : Request = Request.Builder()
            .url("http://10.0.2.2:8080")
            .build()

        val callback = object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Client", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                //body 객체를 스트링으로 읽겠다.
                if (response.isSuccessful){
                    Log.e("Client", "${response.body?.string()}")
                }
            }

        }
           client.newCall(request).enqueue(callback) // 바로 실행

    }
}