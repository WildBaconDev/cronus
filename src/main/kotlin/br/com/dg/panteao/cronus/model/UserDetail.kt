package br.com.dg.panteao.cronus.model

import br.com.dg.panteao.cronus.model.Usuario
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(
    private val usuario: Usuario,
) : UserDetails {

    override fun getAuthorities() = mutableListOf<GrantedAuthority> ()

    override fun getPassword() = usuario.password

    override fun getUsername() = usuario.username

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

}