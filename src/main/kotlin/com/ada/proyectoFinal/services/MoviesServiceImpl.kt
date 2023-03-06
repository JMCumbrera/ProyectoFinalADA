package com.ada.proyectoFinal.services

import com.ada.proyectoFinal.commons.GenericServiceImpl
import com.ada.proyectoFinal.models.Movie
import com.ada.proyectoFinal.repositories.MoviesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class MoviesServiceImpl : MoviesServiceAPI, GenericServiceImpl<Movie, Long>() {
    @Autowired
    lateinit var moviesRepository: MoviesRepository

    override val dao: CrudRepository<Movie, Long>
        get() = moviesRepository
}