package com.example.uasmobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val userName = intent.getStringExtra("USER_NAME")
        val userCity = intent.getStringExtra("USER_CITY")
        val userStatus = intent.getStringExtra("USER_STATUS")
        val userImage = intent.getStringExtra("USER_IMAGE")

        userNameText.text = userName
        userCityText.text = userCity
        userStatusText.text = userStatus
        Picasso.get().load(userImage).into(userImageView)
    }
}