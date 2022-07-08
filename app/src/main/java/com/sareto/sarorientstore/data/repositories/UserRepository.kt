package com.sareto.sarorientstore.data.repositories

import com.sareto.sarorientstore.data.network.FirebaseSource

class UserRepository(private val firebase:FirebaseSource) {
    fun login(email:String, password:String)=firebase.login(email, password)
    fun signup(email: String, password: String)= firebase.register(email,password)
    fun currentUser()= firebase.currentUser()
    fun logout()= firebase.logout()
}