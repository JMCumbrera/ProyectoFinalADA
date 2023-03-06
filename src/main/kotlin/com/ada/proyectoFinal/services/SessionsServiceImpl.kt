package com.ada.proyectoFinal.services

import com.ada.proyectoFinal.commons.GenericServiceImpl
import com.ada.proyectoFinal.models.Session
import com.ada.proyectoFinal.repositories.SessionsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class SessionsServiceImpl : SessionsServiceAPI, GenericServiceImpl<Session, Long>() {
    @Autowired
    lateinit var sessionsRepository: SessionsRepository

    override val dao: CrudRepository<Session, Long>
        get() = sessionsRepository
}