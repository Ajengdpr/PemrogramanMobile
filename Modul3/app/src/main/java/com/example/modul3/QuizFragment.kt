package com.example.modul3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.modul3.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {

    private lateinit var viewModel: QuizViewModel
    private lateinit var binding: FragmentQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        binding.quizViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
            binding.score.text = "SCORE: $newScore"
        })

        binding.submitButton.setOnClickListener { onSubmitWord() }
        binding.skipButton.setOnClickListener { onSkipWord() }

        return binding.root
    }

    private fun onSubmitWord() {
        val userWord = binding.wordInput.text.toString()
        if (viewModel.isUserWordCorrect(userWord)) {
            viewModel.updateScore()
            if (viewModel.hasMoreWords()) {
                viewModel.nextWord()
            } else {
                findNavController().navigate(R.id.action_quizFragment_to_scoreFragment)
            }
        } else {
            Toast.makeText(activity, "Try again!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onSkipWord() {
        if (viewModel.hasMoreWords()) {
            viewModel.nextWord()
        } else {
            findNavController().navigate(R.id.action_quizFragment_to_scoreFragment)
        }
    }
}