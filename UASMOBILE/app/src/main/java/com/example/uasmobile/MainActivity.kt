package com.example.uasmobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uasmobile.adapter.UserAdapter
import com.example.uasmobile.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = UserAdapter { user ->
            val intent = Intent(this, UserDetailActivity::class.java).apply {
                putExtra("USER_NAME", user.name)
                putExtra("USER_CITY", user.address.city)
                putExtra("USER_STATUS", user.username)
                putExtra("USER_IMAGE", "https://via.placeholder.com/150") // Placeholder image URL
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        userViewModel.users.observe(this, Observer { users ->
            adapter.submitList(users)
        })

        userViewModel.fetchUsers()
    }
}