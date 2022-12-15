package com.phinespec.moendemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.phinespec.moendemo.adapters.ItemClickListener
import com.phinespec.moendemo.adapters.ItemListAdapter
import com.phinespec.moendemo.databinding.FragmentItemListBinding
import com.phinespec.moendemo.viewmodels.SharedViewModel


class ItemListFragment : Fragment() {

    private lateinit var binding: FragmentItemListBinding

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.rvItemList.adapter = ItemListAdapter( ItemClickListener { item ->
            viewModel.setCurrentItem(item)
            val action = ItemListFragmentDirections.actionItemListFragmentToItemDetailFragment()
            findNavController().navigate(action)
        })
    }
}