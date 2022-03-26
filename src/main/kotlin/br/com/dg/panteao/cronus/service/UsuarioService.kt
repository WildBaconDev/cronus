package br.com.dg.panteao.cronus.service

import br.com.dg.panteao.cronus.dto.UsuarioRequestDTO
import br.com.dg.panteao.cronus.dto.UsuarioResponseDTO
import br.com.dg.panteao.cronus.model.UserDetail
import br.com.dg.panteao.cronus.repository.UsuarioRepository
import org.slf4j.LoggerFactory
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    val usuarioRepository: UsuarioRepository,
) : UserDetailsService {

    val logger = LoggerFactory.getLogger(this::class.java)

    fun createUser(userRequest: UsuarioRequestDTO): UsuarioResponseDTO {
        logger.info("username={}; email={};", userRequest.username, userRequest.email)
        val usuario = UsuarioRequestDTO.to(userRequest)
        usuario.password = BCryptPasswordEncoder().encode(usuario.password)
        return UsuarioResponseDTO.of(usuarioRepository.save(usuario))
    }

    override fun loadUserByUsername(username: String): UserDetails {
        logger.info("username={};", username)
        val user = usuarioRepository.findByUsername(username) ?: throw UsernameNotFoundException(username)
        return UserDetail(user)
    }
}