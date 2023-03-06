package com.ada.proyectoFinal.models

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "nick")
    var nick: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "profilePicture")
    var profilePicture: String
) {
}