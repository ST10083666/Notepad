package com.example.notepad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    // Firebase database reference
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase database
        database = FirebaseDatabase.getInstance().reference

        // Connect UI elements
        val noteTitle = findViewById<EditText>(R.id.noteTitle)
        val noteDescription = findViewById<EditText>(R.id.noteDescription)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val viewNotesButton = findViewById<Button>(R.id.viewNotesButton)

        // Save button click listener
        saveButton.setOnClickListener {
            val title = noteTitle.text.toString().trim()
            val description = noteDescription.text.toString().trim()

            // Validate input
            if (title.isEmpty()) {
                Toast.makeText(this, "Please enter a title", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create a new note with the current date
            val currentDate = getCurrentDate()
            val note = Note(
                title = title,
                description = description,
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
        // Generate a unique ID for each note
        val noteId = database.push().key

        // Make sure the note ID is not null
        if (noteId != null) {
            database.child("notes").child(noteId).setValue(note)
                .addOnSuccessListener {
                    // Display success message
                    Toast.makeText(this, "Note saved successfully", Toast.LENGTH_SHORT).show()

                    // Optionally clear the input fields after saving
                    findViewById<EditText>(R.id.noteTitle).text.clear()
                    findViewById<EditText>(R.id.noteDescription).text.clear()
                }
                .addOnFailureListener {
                    // Display error message
                    Toast.makeText(this, "Failed to save note", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
