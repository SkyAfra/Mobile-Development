package com.example.skyafra.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.skyafra.activity.AboutActivity
import com.example.skyafra.activity.HomeCameraActivity
import com.example.skyafra.activity.LoginActivity
import com.example.skyafra.activity.NonOrganicActivity
import com.example.skyafra.activity.OrganicActivity
import com.example.skyafra.databinding.FragmentHome2Binding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class HomeFragment2 : Fragment() {

    private var _binding: FragmentHome2Binding? = null
    private val binding get() = _binding!!
    private val handler = Handler(Looper.getMainLooper())
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

    private val updateTimeTask = object : Runnable {
        override fun run() {
            val currentDateTime = dateFormat.format(Date())
            binding.dateTimeTextView.text = currentDateTime
            handler.postDelayed(this, 1000)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHome2Binding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toCamera.setOnClickListener {
            val intent = Intent(requireContext(), HomeCameraActivity::class.java)
            startActivity(intent)
        }

        binding.toOrganic.setOnClickListener {
            val intent = Intent(requireContext(), OrganicActivity::class.java)
            startActivity(intent)
        }

        binding.toNonorganic.setOnClickListener {
            val intent = Intent(requireContext(), NonOrganicActivity::class.java)
            startActivity(intent)
        }

        binding.toAbout.setOnClickListener {
            val intent = Intent(requireContext(), AboutActivity::class.java)
            startActivity(intent)
        }

        handler.post(updateTimeTask)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        handler.removeCallbacks(updateTimeTask)
    }
}