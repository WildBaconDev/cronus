package br.com.dg.panteao.cronus.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "statusEvento")
data class Status(
    @Id var id: String? = null,
    val nome: String,
)
