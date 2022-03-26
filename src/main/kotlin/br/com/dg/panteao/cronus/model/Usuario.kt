package br.com.dg.panteao.cronus.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("usuario")
data class Usuario(
    @Id val username: String,
    val email: String,
    var password: String,
)
