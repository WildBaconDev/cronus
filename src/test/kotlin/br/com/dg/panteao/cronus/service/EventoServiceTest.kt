package br.com.dg.panteao.cronus.service

import br.com.dg.panteao.cronus.dto.AtividadeRequestDTO
import br.com.dg.panteao.cronus.exception.NotFoundException
import br.com.dg.panteao.cronus.model.Atividade
import br.com.dg.panteao.cronus.model.Evento
import br.com.dg.panteao.cronus.model.StatusAtividade
import br.com.dg.panteao.cronus.repository.EventoRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime
import java.util.*

class EventoServiceTest {

    @InjectMockKs
    lateinit var eventoService: EventoService

    @MockK
    lateinit var eventoRepository: EventoRepository

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `should save evento`() {

        val atividade = createAtividadeRequest()

        every { eventoRepository.findById(any()) } returns Optional.of(Evento(titulo = "test", id = "123"))
        every { eventoRepository.save(any()) } returns Evento(titulo = "test")

        val response = eventoService.salvarAtividade(atividade)

        Assertions.assertNotNull(response)
    }

    @Test
    fun `should update evento`() {

        val atividade = createAtividadeRequest()

        every { eventoRepository.findById(any()) } returns Optional.of(Evento(titulo = "test", id = "123", atividades = mutableListOf(createAtividade())))
        every { eventoRepository.save(any()) } returns Evento(titulo = "test")

        val response = eventoService.salvarAtividade(atividade)

        Assertions.assertNotNull(response)
    }

    private fun createAtividade() =
        Atividade(titulo = "test", id = "123", status = StatusAtividade.INICIO, dataInicio = LocalDateTime.now())

    @Test
    fun `should throw not found exception`() {
        every { eventoRepository.findById(any()) } returns Optional.empty()

        assertThrows<NotFoundException> {
            eventoService.salvarAtividade(createAtividadeRequest())
        }
    }

    private fun createAtividadeRequest() = AtividadeRequestDTO(
        id = "123",
        eventoId = "123",
        titulo = "test",
        dataInicio = LocalDateTime.now(),
        status = StatusAtividade.INICIO,
    )
}