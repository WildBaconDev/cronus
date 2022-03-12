package br.com.dg.panteao.cronus.service

import br.com.dg.panteao.cronus.dto.EventoApresentacaoDTO
import br.com.dg.panteao.cronus.dto.EventoFormDTO
import br.com.dg.panteao.cronus.repository.EventoRepository
import org.springframework.stereotype.Service

@Service
class EventoService(
    val eventoRepository: EventoRepository,
    val statusService: StatusService,
    val categoriaService: CategoriaService,
) {

    fun salvar(evento: EventoFormDTO): EventoApresentacaoDTO {
        val eventoParaSalvar = EventoFormDTO.toEvento(evento)

        evento.status?.let {
            statusService.findById(evento.status).ifPresent {
                eventoParaSalvar.status = it
            }
        }

        eventoParaSalvar.categoria = evento.categoria?.map { categoriaService.findById(it).get() }

        return EventoApresentacaoDTO.ofEvento(eventoRepository.save(eventoParaSalvar))
    }

    fun consultarEventos() = eventoRepository.findAll().map { evento ->
            val eventoTransformado = EventoApresentacaoDTO.ofEvento(evento)

            evento.status?.let { status ->
                statusService.findById(status.id!!).ifPresent {
                    eventoTransformado.status = status
                }
            }

            eventoTransformado.categoria = evento.categoria?.map { categoriaService.findById(it.id!!).get() }

            eventoTransformado
        }

    fun remover(id: String) = eventoRepository.deleteById(id)


}
