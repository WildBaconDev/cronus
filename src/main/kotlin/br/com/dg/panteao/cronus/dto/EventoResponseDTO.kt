package br.com.dg.panteao.cronus.dto

import br.com.dg.panteao.cronus.model.Categoria
import br.com.dg.panteao.cronus.model.Evento
import br.com.dg.panteao.cronus.model.Status
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class EventoResponseDTO(
    val id: String? = null,
    val titulo: String,
    val descricao: String? = null,
    @JsonProperty("data_inicio")
    val dataInicio: LocalDateTime? = null,
    @JsonProperty("data_finalizacao")
    val dataFinalizacao: LocalDateTime? = null,
    var categoria: List<Categoria>? = null,
    var status: Status? = null,
    var atividades: List<AtividadeResponseDTO>? = null,
) {
    companion object {
        fun of(evento: Evento) = EventoResponseDTO(
            id = evento.id,
            titulo = evento.titulo,
            descricao = evento.descricao,
            categoria = evento.categoria,
            dataInicio = evento.dataInicio,
            dataFinalizacao = evento.dataFinalizacao,
            status = evento.status,
            atividades = evento.atividades?.map{ atividade -> AtividadeResponseDTO.of(atividade) },
        )
    }
}