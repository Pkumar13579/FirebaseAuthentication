package com.example.iteradmin.firebaseauthentication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ProfileActivity : AppCompatActivity() {

    private lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mAuth = FirebaseAuth.getInstance()

        val text = findViewById<TextView>(R.id.text)
        val logout = findViewById<Button>(R.id.logout)

        val user:FirebaseUser? = mAuth.currentUser

        if (user!=null)
        {
            text.text = user.uid
        }
        logout.setOnClickListener{
            mAuth.signOut()
            finish()
        }

    }
}
