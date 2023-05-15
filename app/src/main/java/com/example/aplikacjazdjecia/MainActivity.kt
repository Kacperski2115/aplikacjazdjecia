package com.example.aplikacjazdjecia

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nastepny=findViewById<Button>(R.id.Nastepny)
        val poprzedni=findViewById<Button>(R.id.Poprzedni)
        val text = findViewById<TextView>(R.id.text1)
        val image = findViewById<ImageView>(R.id.image)
        val images = arrayOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
        poprzedni.setEnabled(false)
        poprzedni.setOnClickListener() {
            if (image.drawable.constantState == resources.getDrawable(images[1]).constantState) {
                image.setImageResource(images[0])
                poprzedni.setEnabled(false)
                text.text="Zdjecie 1 z 3"
            } else if (image.drawable.constantState == resources.getDrawable(images[2]).constantState){
                poprzedni.setEnabled(true)
                nastepny.setEnabled(true)
                image.setImageResource(images[1])
                text.text="Zdjecie 2 z 3"
            }
        }
        nastepny.setOnClickListener() {
            if (image.drawable.constantState == resources.getDrawable(images[0]).constantState) {
                image.setImageResource(images[1])
                text.text="Zdjecie 2 z 3"
                nastepny.setEnabled(true)
                poprzedni.setEnabled(true)
            } else if (image.drawable.constantState == resources.getDrawable(images[1]).constantState) {
                image.setImageResource(images[2])
                text.text="Zdjecie 3 z 3"
                nastepny.setEnabled(false)
                poprzedni.setEnabled(true)
            }
        }
    }
}