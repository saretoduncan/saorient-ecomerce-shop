package com.sareto.sarorientstore.ui.auth

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message:String)
}