package com.example.uasmobile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uasmobile.models.User
import com.example.uasmobile.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {
    val users = MutableLiveData<List<User>>()

    fun fetchUsers() {
        UserRepository().getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    users.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
            }
        })
    }
}