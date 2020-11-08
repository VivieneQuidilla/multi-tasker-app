package com.example.multi_tasker_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.edt_username)
        val password = findViewById<EditText>(R.id.edt_password)
        val register = findViewById<Button>(R.id.btn_register)

        register.setOnClickListener {
            if ((username.text.toString().equals("viviene") && password.text.toString().equals("viviene"))) {
                val intent = Intent(this, MainActivity2::class.java).apply {
                    val toast = Toast.makeText(applicationContext,"Successful login.", Toast.LENGTH_SHORT)
                    toast.show()
                }
                startActivity(intent)
            } else {
                val toast = Toast.makeText(applicationContext,"Error, try again.", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}