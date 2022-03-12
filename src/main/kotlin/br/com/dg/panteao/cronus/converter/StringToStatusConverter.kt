package br.com.dg.panteao.cronus.converter

import br.com.dg.panteao.cronus.model.Status
import com.fasterxml.jackson.databind.util.StdConverter

class StringToStatusConverter: StdConverter<String, Status>() {

    override fun convert(value: String?) = Status(value, "")
}