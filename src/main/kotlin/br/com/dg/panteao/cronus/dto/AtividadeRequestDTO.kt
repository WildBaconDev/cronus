package br.com.dg.panteao.cronus.dto

import br.com.dg.panteao.cronus.converter.StringToStatusAtividadeConverter
import br.com.dg.panteao.cronus.model.StatusAtividade
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AtividadeRequestDTO(
    var id: String? = null,
    @field:NotBlank @JsonProperty(required = true) var eventoId: String = "",
    @field:NotBlank var titulo: String = "",
    @JsonProperty("data_inicio") var dataInicio: LocalDateTime = LocalDateTime.now(),
    @JsonProperty("data_fim") var dataFim: LocalDateTime? = null,
    @field:NotNull @JsonDeserialize(converter = StringToStatusAtividadeConverter::class) var status: StatusAtividade,
)
