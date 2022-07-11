package com.sareto.sarorientstore.data.repositories

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.sareto.sarorientstore.data.models.User
import com.sareto.sarorientstore.data.utility.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception


class UserRepository {
   private val firebaseAuth=FirebaseAuth.getInstance();
    private val databaseReference = FirebaseDatabase.getInstance().getReference("users")

    suspend fun createUser(name:String,email:String, password:String):Resource<AuthResult>{
        return try {
            val registrationResults = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val userId= registrationResults.user?.uid!!
            val newUser= User(name, email)
            databaseReference.child(userId).setValue(newUser).await()
            Resource.Success(registrationResults)
        }catch (e:Exception){
            Resource.Error(e.message?:"unKnown error")
        }
    }
    suspend fun login(email: String, password: String):Resource<AuthResult>{
        return try {
            val result= firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result)
        }catch (e:Exception){
            Resource.Error(e.message?:"unKnown error")
        }
    }

}