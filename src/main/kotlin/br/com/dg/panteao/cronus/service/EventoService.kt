package br.com.dg.panteao.cronus.service

import br.com.dg.panteao.cronus.dto.EventoApresentacaoDTO
import br.com.dg.panteao.cronus.dto.EventoFormDTO
import br.com.dg.panteao.cronus.repository.EventoRepository
import org.springframework.stereotype.Service

@Service
class EventoService(
    val eventoRepository: EventoRepository,
) {

    fun salvar(evento: EventoFormDTO): EventoApresentacaoDTO {
        val eventoParaSalvar = EventoFormDTO.toEvento(evento)

        return EventoApresentacaoDTO.ofEvento(eventoRepository.save(eventoParaSalvar))
    }

    fun consultarEventos() = eventoRepository.findAll()

    fun remover(id: String) = eventoRepository.deleteById(id)

}
