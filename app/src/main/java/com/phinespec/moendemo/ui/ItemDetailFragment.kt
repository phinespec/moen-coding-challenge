package com.phinespec.moendemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.phinespec.moendemo.R
import com.phinespec.moendemo.databinding.FragmentItemDetailBinding
import com.phinespec.moendemo.databinding.FragmentItemListBinding
import com.phinespec.moendemo.viewmodels.SharedViewModel


class ItemDetailFragment : Fragment() {

    private lateinit var binding: FragmentItemDetailBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}