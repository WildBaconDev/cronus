package br.com.dg.panteao.cronus.dto

import br.com.dg.panteao.cronus.model.Usuario
import com.fasterxml.jackson.annotation.JsonProperty

data class UsuarioRequestDTO(
    @JsonProperty(required = true) val username: String,
    @JsonProperty(required = true) val email: String,
    @JsonProperty(required = true) val password: String,
) {
    companion object {
        fun to(usuario: UsuarioRequestDTO): Usuario =
            Usuario(
                username = usuario.username,
                email = usuario.email,
                password = usuario.password
            )
    }
}