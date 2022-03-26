package br.com.dg.panteao.cronus.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UsuarioLoginRequestDTO(
    @JsonProperty(required = true) val username: String,
    @JsonProperty(required = true) val password: String,
)