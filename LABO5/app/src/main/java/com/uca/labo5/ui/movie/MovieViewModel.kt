package com.uca.labo5.ui.movie

import android.text.Spannable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uca.labo5.MovieReviewerApplication
import com.uca.labo5.data.model.MovieModel
import com.uca.labo5.repositories.MovieRepository
import javax.net.ssl.SSLEngineResult.Status

class MovieViewModel(private val repository: MovieRepository): ViewModel() {
    var name = MutableLiveData ("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")
    fun getMovies () = repository.getMovies()

    fun addMovies(movie: MovieModel) = repository.addMovies(movie)

    fun createMovies(){
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val movie = MovieModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!
        )
        addMovies(movie)
        clearData()
        status.value = MOVIE_CREATED
    }
    private fun validateData(): Boolean {
        when{
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }
    fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }
    fun clearStatus (){
        status.value = INACTIVE
    }
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.MovieRepository)
            }
        }
        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Grong information"
        const val INACTIVE = ""
    }
}