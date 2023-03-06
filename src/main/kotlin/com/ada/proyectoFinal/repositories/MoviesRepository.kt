package com.ada.proyectoFinal.repositories

import com.ada.proyectoFinal.models.Movie
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MoviesRepository : CrudRepository<Movie, Long> {}