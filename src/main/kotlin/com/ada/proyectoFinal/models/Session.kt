package com.ada.proyectoFinal.models

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "sessions")
class Session (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "movie_id")
    var movie_id: Long?,

    @Column(name = "room_id")
    var room_id: Long?,

    @Column(name = "date")
    var date: Date
) {
}