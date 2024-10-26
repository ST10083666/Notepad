package com.example.still

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val user = Firebase.auth.currentUser
        var email = findViewById<EditText>(R.id.EmailField)
        val updateEmail = findViewById<Button>(R.id.ConfirmEmailChange)
        val updatePassword = findViewById<TextView>(R.id.UpdatePassword)
        val DeleteAcc = findViewById<TextView>(R.id.DeleteAccount)
        if (user != null) {
            email.setText(user.email.toString())
        }
        updatePassword.setOnClickListener {
            val user = Firebase.auth.currentUser
            user?.let()
            {
                for (profile in it.providerData) {
                    val email = profile.email

                    Firebase.auth.sendPasswordResetEmail(email.toString())
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d("", "Email sent.")
                                Toast.makeText(
                                    this,
                                    "Email Sent To Reset Password",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                }
            }
        }


        updateEmail.setOnClickListener {
            user!!.updateEmail(email.toString()).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("", "User email address updated.")
                    Toast.makeText(this, "Email address Updated", Toast.LENGTH_LONG).show()
                }
            }
        }

        DeleteAcc.setOnClickListener {
            val user = Firebase.auth.currentUser!!
            user.delete()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(
                            "",
                            "User account deleted."
                        )
                        Toast.makeText(this, "Account Deleted", Toast.LENGTH_LONG).show()

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_settings -> {
                    true
                }
                R.id.navigation_hub -> {
                    // Open HubActivity
                    val intent = Intent(this, HubActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_home -> {
                    val intent = Intent(this, HomePage::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }
}