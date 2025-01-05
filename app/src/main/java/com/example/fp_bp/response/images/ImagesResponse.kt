package com.example.fp_bp.response.images

data class ImagesResponse(
    val image_id : Int,
    val user_id : Int,
    val title : String,
    val description : String,
    val image_url : String,
    val created_at : String
)

