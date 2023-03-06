package com.ada.proyectoFinal.controllers

import com.ada.proyectoFinal.models.Movie
import com.ada.proyectoFinal.models.Session
import com.ada.proyectoFinal.services.SessionsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/api/v1/sessions")
@CrossOrigin("*")
class SessionsController {
    @Autowired
    lateinit var sessionsService: SessionsServiceImpl

    // URL -> /api/v1/sessions/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Session>> {
        var listaSessions: MutableList<Session>? = mutableListOf()
        listaSessions = sessionsService.all
        return ResponseEntity(listaSessions, HttpStatus.OK)
    }

    // URL -> /api/v1/sessions/sincetoday
    @GetMapping("/sincetoday")
    fun getSessionsSinceToday(): ResponseEntity<List<Session>> {
        var listaSessions: MutableList<Session>? = mutableListOf() // Lista sesiones
        val actualDate = LocalDateTime.now() // Fecha actual
        val sdf = SimpleDateFormat("yyyy-MM-dd") // Formato de fecha
        val actualDateFormatted = sdf.parse(actualDate.toString()) // Fecha actual con formato

        listaSessions = sessionsService.all

        // Lista de sesiones desde hoy en adelante
        val listaSessionsSinceToday: List<Session> = listaSessions!!.filter {
            println("${sdf.parse(it.date.toString())} vs la fecha de hoy ${actualDateFormatted}")
            sdf.parse(it.date.toString()) >= actualDateFormatted }

        return ResponseEntity(listaSessionsSinceToday, HttpStatus.OK)
    }

    // URL -> /api/v1/sessions/today
    @GetMapping("/today")
    fun getSessionsToday(): ResponseEntity<List<Session>> {
        var listaSessions: MutableList<Session>? = mutableListOf() // Lista sesiones
        val actualDate = LocalDateTime.now() // Fecha actual
        val sdf = SimpleDateFormat("yyyy-MM-dd") // Formato de fecha
        val actualDateFormatted = sdf.parse(actualDate.toString()) // Fecha actual con formato

        listaSessions = sessionsService.all

        // Lista de sesiones de hoy
        val listaSessionsToday: List<Session> = listaSessions!!.filter { sdf.parse(it.date.toString()) == actualDateFormatted }

        return ResponseEntity(listaSessionsToday, HttpStatus.OK)
    }

    // INSERT y DELETE

    @PostMapping("/")
    fun insertSession(@RequestBody sess: Session): ResponseEntity<Session> {
        sessionsService.save(sess)
        return ResponseEntity<Session>(sess, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteSession(@PathVariable id: String): ResponseEntity<String>{
        sessionsService.delete(id.toLong())
        return ResponseEntity<String>("SESSION DELETED", HttpStatus.OK)
    }
}