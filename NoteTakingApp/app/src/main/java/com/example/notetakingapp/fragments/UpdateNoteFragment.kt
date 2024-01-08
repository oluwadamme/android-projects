package com.example.notetakingapp.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notetakingapp.MainActivity
import com.example.notetakingapp.R
import com.example.notetakingapp.adapter.NoteAdapter
import com.example.notetakingapp.databinding.FragmentHomeBinding
import com.example.notetakingapp.databinding.FragmentNewNoteBinding
import com.example.notetakingapp.databinding.FragmentUpdateNoteBinding
import com.example.notetakingapp.model.Note
import com.example.notetakingapp.viewmodel.NoteViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [UpdateNoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpdateNoteFragment : Fragment(R.layout.fragment_update_note) {
    private var _binding: FragmentUpdateNoteBinding?=null
    private val binding get() = _binding
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var currentNote: Note

    private val args:UpdateNoteFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentUpdateNoteBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel=(activity as MainActivity).viewModel
        currentNote=args.note!!

        binding!!.updateNoteTitle.setText(currentNote.noteTitle)
        binding!!.updateNoteBody.setText(currentNote.noteBody)

        // if note is edited
        binding!!.fabDone.setOnClickListener(){
            val title = binding?.updateNoteTitle?.text.toString().trim()
            val body = binding?.updateNoteBody?.text.toString().trim()
            if (title.isNotEmpty()){
                val note =Note(currentNote.id,title,body)
                noteViewModel.updateNote(note)
                view.findNavController().navigate(R.id.action_updateNoteFragment_to_homeFragment)
            }else{
                Toast.makeText(context, "Enter note title", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun deleteNote(){
         AlertDialog.Builder(activity).apply {
             setTitle("Delete Note")
             setMessage("You want to delete this note?")
             setPositiveButton("Delete"){_,_->
                 noteViewModel.deleteNote(currentNote)
                 view?.findNavController()?.navigate(R.id.action_updateNoteFragment_to_homeFragment)

             }
             setNegativeButton("Cancel",null)
         }.create().show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()

        inflater.inflate(R.menu.update_note_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_delete ->{
                deleteNote()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }



}