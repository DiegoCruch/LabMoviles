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
import com.uca.labo5.R
import com.uca.labo5.data.category2
import com.uca.labo5.data.description2
import com.uca.labo5.data.model.MovieModel
import com.uca.labo5.data.name2
import com.uca.labo5.data.qualification2


class BlankFragment3 : Fragment() {

    private lateinit var name: EditText
    private lateinit var categoty: EditText
    private lateinit var description: EditText
    private lateinit var qualification: EditText
    private lateinit var submit: Button
    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = view?.findViewById(R.id.id_name)!!
        categoty = view?.findViewById(R.id.id_Category)!!
        description = view?.findViewById(R.id.id_Descrip)!!
        qualification = view?.findViewById(R.id.id_Quali)!!
        submit = view?.findViewById(R.id.id_bttn)!!
        click()
    }
    private fun click(){
        submit.setOnClickListener {
            val nombre = name.text.toString()
            val categoria = categoty.text.toString()
            val descripcion = description.text.toString()
            val calificacion = qualification.text.toString()
            val movie =    MovieModel(nombre, categoria, descripcion, calificacion)
            viewModel.addMovies(movie)
            Log.d("Lista",viewModel.getMovies().toString())
        }
    }
}