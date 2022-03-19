package br.com.dg.panteao.cronus.repository

import br.com.dg.panteao.cronus.model.Evento
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EventoRepository: MongoRepository<Evento, String> {

    fun findByAtividadesId(atividadeId: String): Evento?

}
