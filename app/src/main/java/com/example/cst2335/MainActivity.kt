package com.example.cst2335


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var sp: SharedPreferences
    private lateinit var email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_lab3)
        sp = getSharedPreferences("sharedPrefs", 0)
        email = findViewById(R.id.email)
        val login: Button = findViewById(R.id.login)
        login.setOnClickListener{ v -> kotlin.run{openProfileActivity()}}
        loadData()
    }
    private fun openProfileActivity(){
        var nextPage = Intent(this, ProfileActivity::class.java)
        nextPage.putExtra("sharedPrefs",email.text.toString())
        startActivity(nextPage)
    }
    private fun saveData(){
        var whatWasTyped = email.text.toString()
        var editor = sp.edit()
        editor.putString("text", whatWasTyped)
        editor.apply()
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
    }
    private fun loadData(){
        var savedString = sp.getString("text", "")
        email.setText(savedString)
    }
    override fun onPause(){
        super.onPause()
        saveData()
    }

}