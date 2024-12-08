package com.example.itc362_hw8_ex2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.itc362_hw8_ex2.databinding.FragmentApodBinding
import com.example.itc362_hw8_ex2.ApodViewModel

class ApodFragment : Fragment() {
    private val viewModel: ApodViewModel by viewModels()
    private var _binding: FragmentApodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentApodBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = ApodAdapter(viewModel.photos.value ?: emptyList()) { photo ->
            findNavController().navigate(ApodFragmentDirections.actionApodFragmentToDetailFragment(photo))
        }
        binding.recyclerView.adapter = adapter
        viewModel.photos.observe(viewLifecycleOwner) { photos ->
            adapter.submitList(photos)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}