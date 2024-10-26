package com.example.still

import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.still.HubActivity
import com.example.still.MainActivity
import com.example.still.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomePage : AppCompatActivity() {
//Various values are declared to handle the mood tracker popup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

//The instance of firebase and the database is stored in the variables


        // Load different GIFs into each button
        loadGif(R.id.focusbtn, R.drawable.focus)
        loadGif(R.id.breathebtn, R.drawable.breathebtn)
        loadGif(R.id.windownbtn, R.drawable.winddownbtn)
        loadGif(R.id.notepadbtn, R.drawable.notepadbtn)
        loadGif(R.id.arcadebtn, R.drawable.arcadebtn)
        loadGif(R.id.meditatebtn, R.drawable.meditate)

        //Methods to show the mood tracker pop up, check whether notification are enabled, create the notification and the display the mood tracker are call


//Buttons and imageViews are made equal to variables
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val winddownButton = findViewById<ImageView>(R.id.windownbtn)
        val notepadbutton = findViewById<ImageView>(R.id.notepadbtn)
        val arcadeButton = findViewById<ImageView>(R.id.arcadebtn)
        val focuButton = findViewById<ImageView>(R.id.focusbtn)
        val meditateButton = findViewById<ImageView>(R.id.meditatebtn)
        val breatheButton = findViewById<ImageView>(R.id.breathebtn)
        val notepadButton = findViewById<ImageView>(R.id.notepadbtn)


        meditateButton.setOnClickListener {
            val intent = Intent(this, MeditateActivity::class.java)
            startActivity(intent)
        }
        notepadButton.setOnClickListener {
            val intent = Intent(this, MainNoteActivity::class.java)
            startActivity(intent)
        }
        breatheButton.setOnClickListener {
            val intent = Intent(this, BreatheActivity::class.java)
            startActivity(intent)
        }
        winddownButton.setOnClickListener {
            val intent = Intent(this, WindDownActivity::class.java)
            startActivity(intent)
        }
        focuButton.setOnClickListener {
            val intent = Intent(this, FocusActivity::class.java)
            startActivity(intent)
        }
//If the arcarde button is clicked then the mini games will open
        arcadeButton.setOnClickListener {
            val intent = Intent(this, ArcadeHubActivity::class.java)
            startActivity(intent)
        }
//This handles the bottom nav bar
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // We are already on the Home page, no need to do anything
                    true
                }
                R.id.navigation_hub -> {
                    // Open HubActivity
                    val intent = Intent(this, HubActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_settings -> {
                    val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }



    //This method loads the gifs used for buttons
    private fun loadGif(imageViewId: Int, gifResourceId: Int) {
        val imageView: ImageView = findViewById(imageViewId)

        Glide.with(this)
            .asGif()
            .load(gifResourceId)
            .apply(
                RequestOptions().transform(
                    CenterCrop(),
                    RoundedCorners(16)
                )
            )
            .into(imageView)
    }
}
