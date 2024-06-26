package com.kkyume.android.todaytnotice

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main(){
    Thread{
        val port = 8080
        val server = ServerSocket(port)

        while (true){
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


            //순서 잘 맞아아ㅑ햄

            printer.println("HTTP/1.1 200 OK")
            printer.println("Content-Type : text/html\r\n")

            printer.println("{\"message\" : \"Hello World\"}")
            printer.println("\r\n")
            printer.flush()
            printer.close()

            reader.close()
        }

    }.start()

}