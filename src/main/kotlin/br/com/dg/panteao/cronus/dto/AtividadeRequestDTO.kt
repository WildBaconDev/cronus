package br.com.dg.panteao.cronus.dto

import br.com.dg.panteao.cronus.converter.StringToStatusAtividadeConverter
import br.com.dg.panteao.cronus.model.StatusAtividade
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AtividadeRequestDTO (
    var id: String? = null,
    @NotBlank
    val eventoId: String,
    @NotBlank
    val titulo: String,
    @NotNull
    @JsonProperty("data_inicio")
    val dataInicio: LocalDateTime,
    @JsonProperty("data_fim")
    var dataFim: LocalDateTime? = null,
    @NotNull
    @JsonDeserialize(converter = StringToStatusAtividadeConverter::class)
    val status: StatusAtividade,
)
