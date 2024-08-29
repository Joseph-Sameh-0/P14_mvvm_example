package com.example.p14_mvvm

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.p14_mvvm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()
    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.scoreTeamOne.observe(viewLifecycleOwner, Observer {
            binding.teamOneScore.text = it.toString()
        })
        viewModel.scoreTeamTwo.observe(viewLifecycleOwner, Observer {
            binding.teamTwoScore.text = it.toString()

        })
        binding.increaseScoreTeamOne.setOnClickListener {
            viewModel.increaseTeamOneScore()
        }
        binding.increaseScoreTeamTwo.setOnClickListener {
            viewModel.increaseTeamTwoScore()
        }

        binding.showResult.setOnClickListener {
            viewModel.checkFinalResult()
            findNavController().navigate(R.id.resultFragment)
        }

        binding.clear.setOnClickListener {
            viewModel.clear()
        }




    }
}