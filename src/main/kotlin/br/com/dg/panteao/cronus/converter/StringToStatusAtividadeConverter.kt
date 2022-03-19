package br.com.dg.panteao.cronus.converter

import br.com.dg.panteao.cronus.exception.InvalidAtividadeStatusException
import br.com.dg.panteao.cronus.model.StatusAtividade
import com.fasterxml.jackson.databind.util.StdConverter

class StringToStatusAtividadeConverter : StdConverter<String, StatusAtividade>() {
    override fun convert(value: String?): StatusAtividade {
        try {
            val statusString = value.takeIf { v -> v !== null && v.isNotBlank() }
                ?: throw IllegalArgumentException()

            return StatusAtividade.valueOf(statusString)
        } catch(e: IllegalArgumentException) {
            throw InvalidAtividadeStatusException("Status inválido")
        }
    }
}