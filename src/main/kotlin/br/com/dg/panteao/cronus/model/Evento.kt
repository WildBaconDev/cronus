package br.com.dg.panteao.cronus.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import java.time.LocalDateTime

@Document(collection = "evento")
data class Evento(
    @Id var id: String? = null,
    val titulo: String,
    var descricao: String? = null,
    @DocumentReference
    var categoria: List<Categoria>? = null,
    val dataInicio: LocalDateTime = LocalDateTime.now(),
    var dataFinalizacao: LocalDateTime? = null,
    @DocumentReference
    var status: Status? = null,
)
