package com.example.modul3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.modul3.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding
    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScoreBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(QuizViewModel::class.java)
        binding.finalScore.text = "You scored: ${viewModel.score.value}"
        binding.playAgainButton.setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_quizFragment)
        }
        return binding.root
    }
}