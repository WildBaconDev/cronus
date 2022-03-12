package br.com.dg.panteao.cronus.dto

import br.com.dg.panteao.cronus.model.Categoria
import br.com.dg.panteao.cronus.model.Evento
import br.com.dg.panteao.cronus.model.Status
import java.time.LocalDateTime

data class EventoApresentacaoDTO(
    val id: String? = null,
    val titulo: String,
    val descricao: String? = null,
    val dataInicio: LocalDateTime? = null,
    val dataFinalizacao: LocalDateTime? = null,
    var categoria: List<Categoria>? = null,
    var status: Status? = null,
) {
    companion object Mapper {
        fun ofEvento(evento: Evento) = EventoApresentacaoDTO(
            id = evento.id,
            titulo = evento.titulo,
            descricao = evento.descricao,
            categoria = evento.categoria,
            dataInicio = evento.dataInicio,
            dataFinalizacao = evento.dataFinalizacao,
            status = evento.status
        )
    }
}