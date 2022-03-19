package br.com.dg.panteao.cronus.dto

import br.com.dg.panteao.cronus.model.Categoria
import br.com.dg.panteao.cronus.model.Evento
import br.com.dg.panteao.cronus.model.Status
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank

data class EventoRequestDTO(
    val id: String?,
    @field:NotBlank
    val titulo: String,
    val descricao: String?,
    val categoria: List<String>?,
    @JsonProperty("data_inicio")
    val dataInicio: LocalDateTime?,
    @JsonProperty("data_finalizacao")
    val dataFinalizacao: LocalDateTime?,
    val status: String?,
) {
    companion object Mapper {
        fun to(eventoResponseDTO: EventoRequestDTO) = Evento(
            id = eventoResponseDTO.id,
            titulo = eventoResponseDTO.titulo,
            descricao = eventoResponseDTO.descricao,
            dataFinalizacao = eventoResponseDTO.dataFinalizacao,
            categoria = eventoResponseDTO.categoria?.map { Categoria(it, "") },
            status = Status(eventoResponseDTO.status, "")
        )
    }
}