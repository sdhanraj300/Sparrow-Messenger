package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class home_screen : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
    }

    //code for signUp
    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    // Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                } else {
                    // If sign up fails, display a message to the user.
                    // Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    // Toast.makeText(baseContext, "Authentication failed.",
                        // Toast.LENGTH_SHORT).show()

                }
            }
    }
}