package com.ada.proyectoFinal.services

import com.ada.proyectoFinal.commons.GenericServiceImpl
import com.ada.proyectoFinal.models.User
import com.ada.proyectoFinal.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class UsersServiceImpl : UsersServiceAPI, GenericServiceImpl<User, Long>() {
    @Autowired
    lateinit var usersRepository: UsersRepository

    fun getUserByNick(nick: String): User? {
        val listaUsers = this.all
        var idUser: Long = 0

        if (listaUsers != null) { for (user in listaUsers) if (user.nick == nick) idUser = user.id!! }

        return this[idUser]
    }

    override val dao: CrudRepository<User, Long>
        get() = usersRepository
}