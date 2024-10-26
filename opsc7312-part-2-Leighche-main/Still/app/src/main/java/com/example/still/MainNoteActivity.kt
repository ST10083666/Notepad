package com.example.still

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

class MainNoteActivity : AppCompatActivity() {

    // Firebase database reference
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_note)

        // Enable persistence (suggest moving this to the Application class)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)

        // Initialize Firebase database
        database = FirebaseDatabase.getInstance().reference
        database.child("notes").keepSynced(true)  // Keep "notes" synced




        // Connect UI elements
        val noteTitle = findViewById<EditText>(R.id.noteTitle)
        val noteDescription = findViewById<EditText>(R.id.noteDescription)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val viewNotesButton = findViewById<Button>(R.id.viewNotesButton)

        // Retrieve intent extras
        val noteId = intent.getStringExtra("noteId")
        val title = intent.getStringExtra("noteTitle")
        val description = intent.getStringExtra("noteDescription")

        val currentUser = FirebaseAuth.getInstance().currentUser
        val userUUID = currentUser?.uid

        // If noteId is not null, it's an edit operation
        if (!noteId.isNullOrEmpty()) {
            noteTitle.setText(title) // Set the title
            noteDescription.setText(description) // Set the description
        }

        // Save button click listener
        saveButton.setOnClickListener {
            val titleText = noteTitle.text.toString().trim() // Use a separate variable for title
            val descriptionText = noteDescription.text.toString().trim() // Use a separate variable for description

            // Validate input
            if (titleText.isEmpty()) {
                Toast.makeText(this, "Please enter a title", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create a note with the current date
            val currentDate = getCurrentDate()
            val note = Note(
                uuid = userUUID.toString(),
                id = noteId ?: database.push().key ?: "", // Use the existing note ID or create a new one
                title = titleText, // Use the titleText variable
                description = descriptionText, // Use the descriptionText variable
                date = currentDate
            )

            // Save the note to Firebase
            saveNoteToFirebase(note)
        }

        // View Notes button click listener
        viewNotesButton.setOnClickListener {
            val intent = Intent(this, NoteViewActivity::class.java)
            startActivity(intent)  // Navigate to the NoteViewActivity
        }
    }

    // Function to get the current date in "YYYY-MM-DD" format
    private fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }

    // Function to save a note to Firebase Realtime Database
    private fun saveNoteToFirebase(note: Note) {
        // Save or update the note in Firebase using the note's ID
        database.child("notes").child(note.id).setValue(note)
            .addOnSuccessListener {
                Toast.makeText(this, "Note saved successfully", Toast.LENGTH_SHORT).show()
                // Optionally clear the input fields after saving
                findViewById<EditText>(R.id.noteTitle).text.clear()
                findViewById<EditText>(R.id.noteDescription).text.clear()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to save note", Toast.LENGTH_SHORT).show()
            }
    }
}
