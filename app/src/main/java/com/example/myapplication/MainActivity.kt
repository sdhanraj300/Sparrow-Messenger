package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

   val db= Firebase.firestore
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null) {
            supportActionBar!!.hide()}

        auth = FirebaseAuth.getInstance()
        var email:EditText=findViewById(R.id.userId)
        var password:EditText=findViewById(R.id.Password)

        var login:Button=findViewById(R.id.login)
        login.setOnClickListener{

            if (email.text.toString().isEmpty() || password.text.toString().isEmpty()) {
                Toast.makeText(this, "Enter your Email and Password", Toast.LENGTH_LONG).show()
            }
            else{
            signIn(email.text.toString(), password.text.toString())
        }}




    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this,"success",Toast.LENGTH_LONG).show()
                    val user = auth.currentUser
                    val intent = Intent(this, home_screen::class.java)
                    startActivity(intent)
                    finish()  //prevent back

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
    }
}