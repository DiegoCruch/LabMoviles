package com.uca.labo5

import android.app.Application
import com.uca.labo5.data.movies
import com.uca.labo5.repositories.MovieRepository

class MovieReviewerApplication: Application() {
    val MovieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}