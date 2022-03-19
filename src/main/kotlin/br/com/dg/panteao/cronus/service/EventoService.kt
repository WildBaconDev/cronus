package br.com.dg.panteao.cronus.service

import br.com.dg.panteao.cronus.dto.AtividadeRequestDTO
import br.com.dg.panteao.cronus.dto.AtividadeResponseDTO
import br.com.dg.panteao.cronus.dto.EventoResponseDTO
import br.com.dg.panteao.cronus.dto.EventoRequestDTO
import br.com.dg.panteao.cronus.exception.NotFoundException
import br.com.dg.panteao.cronus.model.Atividade
import br.com.dg.panteao.cronus.model.Evento
import br.com.dg.panteao.cronus.repository.EventoRepository
import org.bson.types.ObjectId
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EventoService(
    val eventoRepository: EventoRepository,
) {
    val logger = LoggerFactory.getLogger(EventoService::class.java)

    fun salvar(evento: EventoRequestDTO): EventoResponseDTO {
        logger.info("id={}; titulo={};", evento.id, evento.titulo)

        return save(EventoRequestDTO.to(evento))
    }

    fun consultarEventos(): List<EventoResponseDTO> {
        logger.info("")
        return eventoRepository.findAll().map(EventoResponseDTO::of)
    }

    fun remover(id: String) {
        logger.info("id={};", id)
        eventoRepository.deleteById(id)
    }

    fun salvarAtividade(atividade: AtividadeRequestDTO): AtividadeResponseDTO {
        logger.info("evento_id={}; atividade_id={}; atividade_status={}",
            atividade.eventoId, atividade.id, atividade.status)

        val evento = eventoRepository.findById(atividade.eventoId).orElse(null) ?: throw NotFoundException()
        evento.atividades = evento.atividades ?: mutableListOf()

        var atividadeEncontrada = evento.atividades!!.find { atividadeDB -> atividadeDB.id == atividade.id }

        if (atividadeEncontrada == null) {
            atividadeEncontrada = Atividade(
                id = if (atividade.id == null) ObjectId().toString() else atividade.id!!,
                titulo = atividade.titulo,
                dataInicio = atividade.dataInicio,
                dataFim = atividade.dataFim,
                status = atividade.status,
            )

            evento.atividades!!.add(atividadeEncontrada)
        } else {
            atividadeEncontrada.let {
                it.titulo = atividade.titulo
                it.dataInicio = atividade.dataInicio
                it.dataFim = atividade.dataFim
                it.status = atividade.status
            }
        }

        save(evento)

        return AtividadeResponseDTO.of(atividadeEncontrada)
    }

    fun removerAtividade(atividadeId: String) {
        logger.info("atividade_id={};", atividadeId)

        val evento = eventoRepository.findByAtividadesId(atividadeId) ?: throw NotFoundException()
        evento.atividades = evento.atividades!!.filter { atividade -> atividade.id != atividadeId }.toMutableList()
        save(evento)
    }

    private fun save(evento: Evento): EventoResponseDTO {
        return EventoResponseDTO.of(eventoRepository.save(evento))
    }

}
