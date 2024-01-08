package com.example.notetakingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.notetakingapp.MainActivity
import com.example.notetakingapp.R
import com.example.notetakingapp.adapter.NoteAdapter
import com.example.notetakingapp.databinding.FragmentHomeBinding
import com.example.notetakingapp.databinding.FragmentNewNoteBinding
import com.example.notetakingapp.model.Note
import com.example.notetakingapp.viewmodel.NoteViewModel

class NewNoteFragment : Fragment(R.layout.fragment_new_note) {
    private var _binding: FragmentNewNoteBinding?=null
    private val binding get() = _binding
    private lateinit var noteViewModel: NoteViewModel

    private lateinit var mView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentNewNoteBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel=(activity as MainActivity).viewModel
        mView=view

    }

    private fun saveNote(view: View){
        val noteTitle =binding!!.newNoteTitle.text.toString().trim()
        val noteBody=binding!!.newNoteBody.text.toString().trim()
        if (noteTitle.isNotEmpty()){
            val note=Note(0,noteTitle,noteBody)
            noteViewModel.addNote(note)
            Toast.makeText(mView.context, "New note added successfully", Toast.LENGTH_LONG).show()
            view.findNavController().navigate(R.id.action_newNoteFragment_to_homeFragment)
        }else{
            Toast.makeText(mView.context, "Enter note title", Toast.LENGTH_LONG).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.new_note_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save_menu ->{
                saveNote(mView)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}