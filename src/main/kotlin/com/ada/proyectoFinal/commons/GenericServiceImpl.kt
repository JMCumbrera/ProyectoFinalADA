package com.ada.proyectoFinal.commons

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import java.io.Serializable

abstract class GenericServiceImpl<T: Any, ID: Serializable> : GenericServiceAPI<T,ID> {
    override fun save(entity: T): T { return dao.save(entity) }

    override fun delete(id: ID) { dao.deleteById(id) }

    override fun get(id: ID): T? { return dao.findByIdOrNull(id) }

    override val all: MutableList<T>?
        get() {
            val returnList: MutableList<T> = mutableListOf() // Definimos la lista que vamos a devolver
            dao.findAll().forEach{ obj: T -> returnList.add(obj) }
            return returnList;
        }

    abstract val dao: CrudRepository<T, ID>
}