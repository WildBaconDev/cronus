package br.com.dg.panteao.cronus.model

import java.time.LocalDateTime

data class Atividade(
    var id: String,
    var titulo: String,
    var dataInicio: LocalDateTime,
    var dataFim: LocalDateTime? = null,
    var status: StatusAtividade,
)

enum class StatusAtividade {
    INICIO, FIM
}
