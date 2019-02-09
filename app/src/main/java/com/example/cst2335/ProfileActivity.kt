package com.example.cst2335

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.profile_lab3.*

class ProfileActivity : AppCompatActivity() {

    companion object{
        const val PROFILE_ACTIVITY = "PROFILE_ACTIVITY"
        const val SHARED_PREFS = "sharedPrefs"
        const val REQUEST_IMAGE_CAPTURE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_lab3)
        val intent = intent
        profileEmail.setText(intent.getStringExtra(SHARED_PREFS))
        imageButton.setOnClickListener{ dispatchTakePictureIntent()}
    }

    private fun dispatchTakePictureIntent(){
        val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(pictureIntent, REQUEST_IMAGE_CAPTURE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imgBitmap = data?.extras?.get("data")
            if (imgBitmap is Bitmap)
                imageButton.setImageBitmap(imgBitmap)
        }
        Log.e(PROFILE_ACTIVITY, "In function: onActivityResult")
    }

    override fun onStart(){
        super.onStart()
        Log.e(PROFILE_ACTIVITY, "In function: onStart")
    }

    override fun onResume(){
        super.onResume()
        Log.e(PROFILE_ACTIVITY, "In function: onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.e(PROFILE_ACTIVITY, "In function: onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.e(PROFILE_ACTIVITY, "In function: onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.e(PROFILE_ACTIVITY, "In function: onDestroy")
    }

}