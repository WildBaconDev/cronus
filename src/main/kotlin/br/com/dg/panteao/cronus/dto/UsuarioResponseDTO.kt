package br.com.dg.panteao.cronus.dto

import br.com.dg.panteao.cronus.model.Usuario

data class UsuarioResponseDTO(
    val username: String,
    val email: String,
) {
    companion object {
        fun of(usuario: Usuario) = UsuarioResponseDTO(
            username = usuario.username,
            email = usuario.email,
        )
    }
}
