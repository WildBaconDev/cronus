package br.com.dg.panteao.cronus.service

import br.com.dg.panteao.cronus.dto.EventoApresentacaoDTO
import br.com.dg.panteao.cronus.dto.EventoFormDTO
import br.com.dg.panteao.cronus.model.Evento
import br.com.dg.panteao.cronus.repository.EventoRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EventoService(
    val eventoRepository: EventoRepository,
) {
    val logger = LoggerFactory.getLogger(EventoService::class.java)

    fun salvar(evento: EventoFormDTO): EventoApresentacaoDTO {
        logger.info("id={},titulo={}", evento.id, evento.titulo)

        val eventoParaSalvar = EventoFormDTO.toEvento(evento)

        return EventoApresentacaoDTO.ofEvento(eventoRepository.save(eventoParaSalvar))
    }

    fun consultarEventos(): List<Evento> {
        logger.info("")
        return eventoRepository.findAll()
    }

    fun remover(id: String) {
        logger.info("id={}", id)
        eventoRepository.deleteById(id)
    }

}
