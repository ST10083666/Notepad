package com.example.still

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(
    private val noteList: MutableList<Note>,
    private val onEditClicked: (Note) -> Unit,
    private val onDeleteClicked: (Note) -> Unit,
    private val onViewClicked: (Note) -> Unit // New parameter for the view action
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = noteList[position]
        holder.bind(note, onEditClicked, onDeleteClicked, onViewClicked) // Pass the view action
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.noteTitleText)
        private val dateTextView: TextView = itemView.findViewById(R.id.noteDateText)
        private val editButton: Button = itemView.findViewById(R.id.editButton)
        private val deleteButton: Button = itemView.findViewById(R.id.deleteButton)
        private val viewButton: Button = itemView.findViewById(R.id.viewButton)

        fun bind(note: Note, onEditClicked: (Note) -> Unit, onDeleteClicked: (Note) -> Unit, onViewClicked: (Note) -> Unit) {
            titleTextView.text = note.title
            dateTextView.text = note.date

            editButton.setOnClickListener {
                onEditClicked(note)
            }

            deleteButton.setOnClickListener {
                onDeleteClicked(note)
            }

            viewButton.setOnClickListener {
                onViewClicked(note)
            }
        }
    }
}

