package br.com.dg.panteao.cronus.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "categoriaEvento")
data class Categoria(
    @Id var id: String? = null,
    val nome: String,
)
