package com.example.vaibhav.camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast


import kotlinx.android.synthetic.main.activity_main.*
class  MainActivity : AppCompatActivity() {

    val CAMERA_REQUEST_CODE =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cameraButton.setOnClickListener{
            val callcameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if(callcameraIntent.resolveActivity(packageManager)!= null){
                startActivityForResult(callcameraIntent,CAMERA_REQUEST_CODE)
            }
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    when(requestCode)
    {
        CAMERA_REQUEST_CODE->{
            if(resultCode==Activity.RESULT_OK && data != null){
                photoimageView.setImageBitmap(data.extras.get("data")as Bitmap)
            }
        }

        else->{
            Toast.makeText(this,"Unrequired request code",Toast.LENGTH_SHORT).show()
        }
    }

    }

}
