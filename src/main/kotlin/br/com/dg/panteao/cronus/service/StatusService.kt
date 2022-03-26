package br.com.dg.panteao.cronus.service

import br.com.dg.panteao.cronus.model.Status
import br.com.dg.panteao.cronus.repository.StatusRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class StatusService(
    val statusRepository: StatusRepository
) {
    val logger = LoggerFactory.getLogger(this::class.java)

    fun consultarStatus(): MutableList<Status> {
        logger.info("")
        return statusRepository.findAll()
    }
    fun salvar(status: Status): Status {
        logger.info("id={}, status={}", status.id, status.nome)
        return statusRepository.save(status)
    }
    fun findById(id: String): Optional<Status> {
        logger.info("id={}", id)
        return statusRepository.findById(id)
    }
    fun remover(id: String) {
        logger.info("id={}", id)
        statusRepository.deleteById(id)
    }

}
