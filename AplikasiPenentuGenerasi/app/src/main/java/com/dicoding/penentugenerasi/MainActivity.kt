package com.dicoding.penentugenerasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Inisialisasi Komponen
        var edTahun = findViewById<EditText>(R.id.edTahun)
        var btnKlik = findViewById<Button>(R.id.btnKlik)
        var tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnKlik.setOnClickListener {
            val input = edTahun.text.toString()
            val hasil = when (input.toInt()) {
                in 1922..1945 -> "Tradisionalis"
                in 1946..1964 -> "Baby Boomers"
                in 1965..1980 -> "X"
                in 1981..1994 -> "Milenial"
                in 1995..2010 -> "Z"
                in 2010..2025 -> "Alpha"
                else -> "apa aku gak tau mas"
            }
            tvHasil.text = "Kamu generasi $hasil"
        }
    }
}