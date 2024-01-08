package com.example.notetakingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notetakingapp.MainActivity
import com.example.notetakingapp.R
import com.example.notetakingapp.adapter.NoteAdapter
import com.example.notetakingapp.databinding.FragmentHomeBinding
import com.example.notetakingapp.databinding.NoteLayoutBinding
import com.example.notetakingapp.model.Note
import com.example.notetakingapp.viewmodel.NoteViewModel


class HomeFragment : Fragment(R.layout.fragment_home), SearchView.OnQueryTextListener {
    private var _binding:FragmentHomeBinding?=null
    private val binding get() = _binding
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel=(activity as MainActivity).viewModel

        setRecyclerView()

        binding?.floatActionBtn?.setOnClickListener(){
            it.findNavController().navigate(R.id.action_homeFragment_to_newNoteFragment)
        }
    }

    private fun setRecyclerView() {
        noteAdapter= NoteAdapter()

        binding!!.recyclerView.apply {
            layoutManager=StaggeredGridLayoutManager(
                2,StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
            adapter=noteAdapter
        }

        activity.let {
            noteViewModel.getAllNotes().observe(
                viewLifecycleOwner,{
                    note -> noteAdapter.differ.submitList(note)
                    updateUI(note)
                }
            )
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.home_menu,menu)
        val mMenuSearch=menu.findItem(R.id.menu_search).actionView as SearchView
        mMenuSearch.isSubmitButtonEnabled=false
        mMenuSearch.setOnQueryTextListener(this)

    }

    private fun updateUI(note: List<Note>?) {
        if (note != null) {
            if (note.isNotEmpty()){
                binding!!.homeCardView.visibility=View.GONE
                binding!!.recyclerView.visibility=View.VISIBLE
            }else{
                binding!!.homeCardView.visibility=View.VISIBLE
                binding!!.recyclerView.visibility=View.GONE
            }
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
//        noteViewModel.searchNote(query)
      return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText!=null){
            println("%${newText.toLowerCase()}")
            noteViewModel.searchNote("%${newText.toLowerCase()}%").observe(
                this,{list->noteAdapter.differ.submitList(list)}
            )
        }
       return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}