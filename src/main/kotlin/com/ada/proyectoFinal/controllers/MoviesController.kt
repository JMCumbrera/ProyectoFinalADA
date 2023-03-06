package com.ada.proyectoFinal.controllers

import com.ada.proyectoFinal.models.Movie
import com.ada.proyectoFinal.services.MoviesServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin("*")
class MoviesController {
    @Autowired
    lateinit var moviesService : MoviesServiceImpl

    // URL -> /api/v1/movies/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Movie>> {
        var listaMovies: MutableList<Movie>? = mutableListOf()
        listaMovies = moviesService.all
        return ResponseEntity(listaMovies, HttpStatus.OK)
    }

    // URL -> /api/v1/movies/id
    @GetMapping("/{id}")
    fun getOneMovie(@PathVariable id: String): ResponseEntity<Movie>{
        var idMovie: Long = id.toLong()
        var movie: Movie? = moviesService[idMovie]

        return ResponseEntity<Movie>(movie, HttpStatus.OK)
    }

    // INSERT y DELETE

    @PostMapping("/")
    fun insertProducto(@RequestBody mov: Movie): ResponseEntity<Movie> {
        moviesService.save(mov)
        return ResponseEntity<Movie>(mov, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteProducto(@PathVariable id: String): ResponseEntity<String>{
        moviesService.delete(id.toLong())
        return ResponseEntity<String>("MOVIE DELETED", HttpStatus.OK)
    }
}