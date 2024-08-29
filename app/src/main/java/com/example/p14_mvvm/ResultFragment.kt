package com.example.p14_mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.p14_mvvm.databinding.FragmentHomeBinding
import com.example.p14_mvvm.databinding.FragmentResultBinding
import kotlin.math.absoluteValue


class ResultFragment : Fragment() {
    val viewModel: HomeViewModel by activityViewModels()
    lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.finalResult.observe(viewLifecycleOwner, Observer {
            binding.showResult.text = it
        })
    }

}