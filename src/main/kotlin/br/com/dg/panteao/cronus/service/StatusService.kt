package br.com.dg.panteao.cronus.service

import br.com.dg.panteao.cronus.model.Status
import br.com.dg.panteao.cronus.repository.StatusRepository
import org.springframework.stereotype.Service

@Service
class StatusService(
    val statusRepository: StatusRepository
) {
    fun consultarStatus() = statusRepository.findAll()
    fun salvar(status: Status) = statusRepository.save(status)
    fun findById(id: String) = statusRepository.findById(id)

}
