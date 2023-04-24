package com.uca.labo5.repositories

import com.uca.labo5.data.model.MovieModel

class MovieRepository (private val movies: MutableList<MovieModel>){
    fun getMovies () = movies
    fun addMovies (movie: MovieModel) = movies.add(movie)
}