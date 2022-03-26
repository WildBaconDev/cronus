package br.com.dg.panteao.cronus.repository

import br.com.dg.panteao.cronus.model.Usuario
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: MongoRepository<Usuario, String> {

    fun findByUsername(username: String): Usuario?
}
