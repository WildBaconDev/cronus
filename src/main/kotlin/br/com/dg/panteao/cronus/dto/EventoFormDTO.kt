package br.com.dg.panteao.cronus.dto

import br.com.dg.panteao.cronus.model.Evento
import java.time.LocalDateTime

data class EventoFormDTO(
    val id: String?,
    val titulo: String,
    val descricao: String?,
    val categoria: List<String>?,
    val dataInicio: LocalDateTime?,
    val dataFinalizacao: LocalDateTime?,
    val status: String?,
) {
    companion object Mapper {
        fun toEvento(eventoFormDTO: EventoFormDTO) = Evento(
            id = eventoFormDTO.id,
            titulo = eventoFormDTO.titulo,
            descricao = eventoFormDTO.descricao,
            dataFinalizacao = eventoFormDTO.dataFinalizacao
        )
    }
}