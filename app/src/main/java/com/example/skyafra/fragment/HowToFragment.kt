package com.example.skyafra.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.skyafra.databinding.FragmentHowToBinding


class HowToFragment : Fragment() {

    private var _binding: FragmentHowToBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using view binding
        _binding = FragmentHowToBinding.inflate(inflater, container, false)
        return binding.root

    }


}