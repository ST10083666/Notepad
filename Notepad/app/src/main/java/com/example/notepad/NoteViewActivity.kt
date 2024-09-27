package com.example.notepad

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class NoteViewActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var noteList: MutableList<Note>
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_view)

        // Initialize Firebase reference
        database = FirebaseDatabase.getInstance().reference.child("notes")

        // Initialize RecyclerView and the adapter
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        noteList = mutableListOf()
        noteAdapter = NoteAdapter(noteList, { note -> editNote(note) }, { note -> deleteNote(note) })
        recyclerView.adapter = noteAdapter

        // Fetch notes from Firebase
        fetchNotesFromFirebase()
    }

    // Function to fetch all notes from Firebase
    private fun fetchNotesFromFirebase() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                noteList.clear() // Clear the list to avoid duplication
                for (noteSnapshot in snapshot.children) {
                    val note = noteSnapshot.getValue(Note::class.java)
                    note?.let { noteList.add(it) }
                }
                noteAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@NoteViewActivity, "Failed to load notes", Toast.LENGTH_SHORT).show()
            }
        })
    }

    // Function to handle note editing
    private fun editNote(note: Note) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("noteId", note.date) // Pass unique ID (date or other identifier)
        startActivity(intent)
    }

    // Function to handle note deletion
    private fun deleteNote(note: Note) {
        database.child(note.date).removeValue()
            .addOnSuccessListener {
                Toast.makeText(this, "Note deleted", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to delete note", Toast.LENGTH_SHORT).show()
            }
    }
}
