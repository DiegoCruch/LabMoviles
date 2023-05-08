package com.uca.labo5.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.uca.labo5.R
import com.uca.labo5.data.model.MovieModel
import com.uca.labo5.databinding.FragmentBlank3Binding
import  com.uca.labo5.ui.movie.MovieViewModel


class NewMovieFragment : Fragment() {

    private lateinit var name: EditText
    private lateinit var categoty: EditText
    private lateinit var description: EditText
    private lateinit var qualification: EditText
    private lateinit var submit: Button



    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }
    private lateinit var binding: FragmentBlank3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()

    }
    private fun setViewModel(){
        binding.viewmodel = movieViewModel
    }
    private fun observeStatus(){
        movieViewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(MovieViewModel.WRONG_INFORMATION) ->{
                    Log.d(APP_TAG, status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, movieViewModel.getMovies().toString())

                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }

        }
    }
    companion object{
        const val APP_TAG = "APP TAG"
    }

}