package com.ada.proyectoFinal.controllers

import com.ada.proyectoFinal.models.User
import com.ada.proyectoFinal.services.UsersServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
class UsersController {
    @Autowired
    lateinit var usersService : UsersServiceImpl

    // URL -> /api/v1/users/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<User>> {
        var listaUsers: MutableList<User>? = mutableListOf()
        listaUsers = usersService.all
        return ResponseEntity(listaUsers, HttpStatus.OK)
    }

    // URL -> /api/v1/users/nick
    @GetMapping("/{nick}")
    fun getOneUser(@PathVariable nick: String): ResponseEntity<Any> {
        val user: User? = usersService.getUserByNick(nick)

        return if (user == null) {
            ResponseEntity<Any>("USER NOT FOUND", HttpStatus.NOT_FOUND)
        } else {
            return ResponseEntity<Any>(user, HttpStatus.OK)
        }
    }

    @PostMapping("/")
    fun insertUsers(@RequestBody usr: User): ResponseEntity<String> {
        usersService.save(usr)
        return ResponseEntity<String>("USER INSERTED", HttpStatus.OK)
    }

    @PutMapping("/{nick}")
    fun updateUser(@PathVariable nick: String, @RequestBody updatedUser: User): ResponseEntity<String> {
        val user: User? = usersService.getUserByNick(nick)

        return if (user != null) {
            usersService.save(updatedUser)
            ResponseEntity<String>("USER UPDATED", HttpStatus.OK)
        } else {
            ResponseEntity<String>("USER NOT FOUND", HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{nick}")
    fun deleteUser(@PathVariable nick: String): ResponseEntity<String> {
        val user: User? = usersService.getUserByNick(nick)
        val userID = user?.id

        return if (user != null) {
            usersService.delete(userID!!)   // Si user no es nulo, userID tampoco lo será
            ResponseEntity<String>("USER DELETED", HttpStatus.OK)
        } else {
            ResponseEntity<String>("USER NOT FOUND", HttpStatus.NOT_FOUND)
        }
    }
}