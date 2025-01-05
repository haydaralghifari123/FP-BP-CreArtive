package com.example.fp_bp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class NewPostActivity : AppCompatActivity() {
    private lateinit var imgNewPost: ImageView
    private lateinit var txtCaption: EditText
    private lateinit var buttonDone: Button
    private var selectedImageUri: Uri? = null

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        val btnBack : ImageButton = findViewById(R.id.btnBack7)
        btnBack.setOnClickListener {
            finish()
        }

        imgNewPost = findViewById(R.id.imageNewPost)
        txtCaption = findViewById(R.id.txtCaption)
        buttonDone = findViewById(R.id.btnPost)

        imgNewPost.setOnClickListener {
            openImageChooser()
        }

        buttonDone.setOnClickListener {
            postImage()
        }
    }

    private fun openImageChooser() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            selectedImageUri = data.data
            Picasso.get().load(selectedImageUri).into(imgNewPost)
        }
    }

    private fun postImage() {
        val caption = txtCaption.text.toString()
//        if (selectedImageUri != null) {
//            // Implement the logic to upload the image and caption to your server
//            // For example, using Retrofit or any other networking library
//        } else {
//            // Handle the case where no image was selected
//        }
    }
}
