package br.com.dg.panteao.cronus.service

import br.com.dg.panteao.cronus.dto.UsuarioRequestDTO
import br.com.dg.panteao.cronus.model.Usuario
import br.com.dg.panteao.cronus.repository.UsuarioRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UsuarioServiceTest {

    @InjectMockKs
    lateinit var usuarioService: UsuarioService

    @MockK
    lateinit var usuarioRepository: UsuarioRepository

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `should save`() {
        val user = UsuarioRequestDTO(
            username = "username",
            email = "email",
            password = "12345",
        )

        every { usuarioRepository.save(any()) } returns Usuario(
            username = "username",
            email = "email",
            password = "12345",
        )

        val response = usuarioService.createUser(user)

        Assertions.assertNotNull(response)
    }

}