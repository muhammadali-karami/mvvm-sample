package com.example.architecture.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.architecture.databinding.FragmentABinding
import com.example.architecture.ui.base.BaseFragment

class AFragment : BaseFragment() {

    lateinit var binding : FragmentABinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            findNavController().navigate(AFragmentDirections.actionAFragmentToBFragment())
        }
    }
}