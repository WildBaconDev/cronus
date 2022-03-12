package br.com.dg.panteao.cronus.controller

import br.com.dg.panteao.cronus.dto.EventoFormDTO
import br.com.dg.panteao.cronus.service.EventoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("evento")
class EventoController(
    val eventoService: EventoService
) {

    @GetMapping
    fun consultar() = ResponseEntity.ok(eventoService.consultarEventos())

    @PostMapping
    fun salvar(@RequestBody evento: EventoFormDTO) = ResponseEntity(eventoService.salvar(evento).id, HttpStatus.CREATED)

    @PutMapping
    fun atualizar(@RequestBody evento: EventoFormDTO) = ResponseEntity(eventoService.salvar(evento).id, HttpStatus.OK)

    @DeleteMapping("/{id}")
    fun remover(@PathVariable("id") id: String) = ResponseEntity(eventoService.remover(id), HttpStatus.NO_CONTENT)

}