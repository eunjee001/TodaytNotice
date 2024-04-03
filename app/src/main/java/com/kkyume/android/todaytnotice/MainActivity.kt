package com.kkyume.android.todaytnotice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kkyume.android.todaytnotice.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Thread{
            val port = 8080
            val server = ServerSocket(port)

            val socket = server.accept()

            /**
             *  socket.getInputStream() // 클라이언트로부터 들어오는 스트림 == 클라이언틔 socket.outputStream
             *  socket.getOutputStream()  // 클라이언트에게 데이터를 주는 스트림 == socket.inputStream
             */

            val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
            val printer = PrintWriter(socket.getOutputStream())

            var input : String ?= "-1"
            while (input != null && input != ""){
                input = reader.readLine()
            }

            Log.e("SERVER", "Read Data $input")

            //순서 잘 맞아아ㅑ햄

            printer.println("HTTP/1.1 200 OK")
            printer.println("Content-Type : text/html\r\n")

            printer.println("<h1> Hello World </h1>")
            printer.println("\r\n")
            printer.flush()
            printer.close()

            reader.close()
        }.start()

    }
}