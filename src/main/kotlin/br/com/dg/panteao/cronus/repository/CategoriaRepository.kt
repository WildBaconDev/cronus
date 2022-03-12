package br.com.dg.panteao.cronus.repository

import br.com.dg.panteao.cronus.model.Categoria
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository: MongoRepository<Categoria, String> {

}
