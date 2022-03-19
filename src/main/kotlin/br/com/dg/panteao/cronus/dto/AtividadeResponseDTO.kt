package br.com.dg.panteao.cronus.dto

import br.com.dg.panteao.cronus.model.Atividade
import br.com.dg.panteao.cronus.model.StatusAtividade
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class AtividadeResponseDTO (
    val id: String,
    val titulo: String,
    @JsonProperty("data_inicio")
    val dataInicio: LocalDateTime,
    @JsonProperty("data_fim")
    var dataFim: LocalDateTime? = null,
    val status: StatusAtividade,
) {

    companion object {
        fun of(atividade: Atividade): AtividadeResponseDTO = AtividadeResponseDTO(
            id = atividade.id,
            titulo = atividade.titulo,
            dataInicio = atividade.dataInicio,
            dataFim = atividade.dataFim,
            status = atividade.status,
        )
    }
}
