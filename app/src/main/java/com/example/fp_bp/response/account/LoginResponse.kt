package com.example.fp_bp.response.account

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val `data` : Data
)
