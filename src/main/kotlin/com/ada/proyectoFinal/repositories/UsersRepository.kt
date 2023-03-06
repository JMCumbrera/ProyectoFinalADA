package com.ada.proyectoFinal.repositories

import com.ada.proyectoFinal.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository : CrudRepository<User, Long> {}