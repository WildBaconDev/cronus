package br.com.dg.panteao.cronus.controller

import br.com.dg.panteao.cronus.dto.EventoRequestDTO
import br.com.dg.panteao.cronus.dto.EventoResponseDTO
import br.com.dg.panteao.cronus.model.Status
import br.com.dg.panteao.cronus.security.JWTUtil
import br.com.dg.panteao.cronus.service.EventoService
import br.com.dg.panteao.cronus.service.UsuarioService
import com.google.gson.Gson
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

private const val BASE_URL = "/evento"

@WithMockUser(username="spring")
@WebMvcTest(EventoController::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EventoControllerTest(
    @Autowired private val mockMvc: MockMvc,
) {

    @MockkBean(relaxed = true)
    private lateinit var jwtUtil: JWTUtil

    @MockkBean
    private lateinit var usuarioService: UsuarioService

    @MockkBean(relaxed = true)
    private lateinit var eventoService: EventoService
    
    @Test
    fun `should return all eventos`() {
        mockMvc.perform(get(BASE_URL))
            .andExpect(status().isOk)
    }

    @Test
    fun `should post an event`() {

        val eventoRequest = EventoRequestDTO(
            status = "INICIO",
            titulo = "titulo",
        )

        val evento = EventoResponseDTO(
            id = "1",
            status = Status(id = "1", nome = "INICIO"),
            titulo = "titulo",
        )
        
        every { eventoService.salvar(any()) } returns evento

        mockMvc.perform(post(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(Gson().toJson(eventoRequest)))
            .andExpect(status().isCreated)
            .andExpect(jsonPath("\$.id").value(evento.id))
            .andExpect(jsonPath("\$.status.nome").value(evento.status?.nome))
            .andExpect(jsonPath("\$.titulo").value(evento.titulo))

    }
}
