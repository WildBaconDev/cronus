package br.com.dg.panteao.cronus.converter

import br.com.dg.panteao.cronus.exception.InvalidStatus
import br.com.dg.panteao.cronus.model.StatusAtividade
import com.fasterxml.jackson.databind.util.StdConverter

class StringToStatusAtividadeConverter: StdConverter<String, StatusAtividade>() {
    override fun convert(value: String?): StatusAtividade {
        val statusString = value.takeIf { v -> v !== null } ?: throw InvalidStatus()

        return StatusAtividade.valueOf(statusString)
    }
}