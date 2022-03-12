package br.com.dg.panteao.cronus.repository

import br.com.dg.panteao.cronus.model.Status
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface StatusRepository: MongoRepository<Status, String> {

}
