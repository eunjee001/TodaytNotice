package com.kkyume.android.todaytnotice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TokenWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.google.gson.Gson
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
    val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editText = binding.serverHostEditText
        val confirmButton = binding.confirmButton
        val informationTextView = binding.informationTextView

        var serverHost = ""

        editText.addTextChangedListener{
            serverHost = it.toString()
        }
        confirmButton.setOnClickListener {
            val request: Request = Request.Builder()
                .url("http://$serverHost:8080")
                .build()

            val callback = object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                    runOnUiThread {
                        Toast.makeText(this@MainActivity, "수신에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                    Log.e("Client", e.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    //body 객체를 스트링으로 읽겠다.
                    if (response.isSuccessful) {
                        val responseData = response.body?.toString()

                        val message = Gson().fromJson(responseData, Message::class.java)
                        runOnUiThread {
                            informationTextView.visibility = View.VISIBLE
                            informationTextView.text= message.message
                            editText.isVisible = false
                            confirmButton.isVisible = false
                        }

                    }else{
                        Toast.makeText(this@MainActivity, "수신에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }

            }
                client.newCall(request).enqueue(callback)
        }

    }
}