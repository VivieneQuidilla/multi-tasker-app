package com.example.multi_tasker_app

import android.app.Activity
import android.content.ActivityNotFoundException
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.widget.Button
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val b_one = findViewById<Button>(R.id.btn_one)
        val b_two = findViewById<Button>(R.id.btn_two)
        val b_three = findViewById<Button>(R.id.btn_three)
        val b_four = findViewById<Button>(R.id.btn_four)
        val b_five = findViewById<Button>(R.id.btn_five)
        val REQUEST_IMAGE_CAPTURE = 1

        b_one.setOnClickListener {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                try {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
                catch (e: ActivityNotFoundException) {
                    val toast = Toast.makeText(applicationContext,"Unable to continue.", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }


        b_two.setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "Timer")
                putExtra(AlarmClock.EXTRA_LENGTH, "5")
                putExtra(AlarmClock.EXTRA_SKIP_UI, true)
            }
            if (intent.resolveActivity(packageManager) != null) startActivity(intent)
        }

        b_three.setOnClickListener {
                val intent = Intent(Settings.ACTION_SETTINGS)
                if (intent.resolveActivity(packageManager) != null) startActivity(intent)
        }

        b_four.setOnClickListener {
            val snackbar = Snackbar.make(it, "Feature will be added soon.", Snackbar.LENGTH_SHORT).setAction("Action", null)
            snackbar.show()
        }

        b_five.setOnClickListener {
            val snackbar = Snackbar.make(it, "Feature is not yet supported by OS version.", Snackbar.LENGTH_SHORT).setAction("Action", null)
            snackbar.show()
        }
    }
}




