package br.com.dg.panteao.cronus.dto

import br.com.dg.panteao.cronus.model.Categoria
import br.com.dg.panteao.cronus.model.Evento
import br.com.dg.panteao.cronus.model.Status
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank

data class EventoRequestDTO(
    val id: String? = null,
    @field:NotBlank
    val titulo: String,
    val descricao: String? = null,
    val categoria: List<String>? = null,
    @JsonProperty("data_inicio")
    val dataInicio: LocalDateTime? = null,
    @JsonProperty("data_finalizacao")
    val dataFinalizacao: LocalDateTime? = null,
    val status: String? = null,
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