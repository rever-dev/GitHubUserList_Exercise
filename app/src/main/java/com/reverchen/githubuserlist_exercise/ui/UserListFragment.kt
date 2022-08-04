package com.reverchen.githubuserlist_exercise.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.reverchen.githubuserlist_exercise.R
import com.reverchen.githubuserlist_exercise.databinding.FragmentUserListBinding
import com.reverchen.githubuserlist_exercise.repository.UserRepo
import com.reverchen.githubuserlist_exercise.view_model.UserListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class UserListFragment : Fragment() {
    
    private lateinit var _viewModel: UserListViewModel
    private lateinit var _binding: FragmentUserListBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewModel = ViewModelProvider(this)[UserListViewModel::class.java]
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater)
        return _binding.root
    }
    
    private val adapter = UserListAdapter()
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.fragUserListRecyclerView.layoutManager = LinearLayoutManager(context)
        _binding.fragUserListRecyclerView.adapter = adapter
        
//        _viewModel.users.observe(viewLifecycleOwner) {
//            _viewModel.users.value = arrayListOf()
////            adapter.submitData(it)
//        }
        lifecycleScope.launch {
            _viewModel.fetchUserData().collect {
                adapter.submitData(it)
            }
        }
    }
    
    
}