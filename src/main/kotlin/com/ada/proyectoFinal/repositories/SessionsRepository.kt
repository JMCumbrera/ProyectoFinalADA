package com.ada.proyectoFinal.repositories

import com.ada.proyectoFinal.models.Session
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SessionsRepository : CrudRepository<Session, Long> {}