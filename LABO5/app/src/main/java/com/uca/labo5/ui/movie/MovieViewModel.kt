package com.uca.labo5.ui.movie

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uca.labo5.MovieReviewerApplication
import com.uca.labo5.data.model.MovieModel
import com.uca.labo5.repositories.MovieRepository

class MovieViewModel(private val repository: MovieRepository): ViewModel() {
    fun getMovies () = repository.getMovies()

    fun addMovies(movie: MovieModel) = repository.addMovies(movie)
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.MovieRepository)
            }
        }
    }
}