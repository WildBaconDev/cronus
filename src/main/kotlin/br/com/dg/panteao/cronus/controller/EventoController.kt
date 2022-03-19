package br.com.dg.panteao.cronus.controller

import br.com.dg.panteao.cronus.dto.AtividadeRequestDTO
import br.com.dg.panteao.cronus.dto.EventoRequestDTO
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
import javax.validation.Valid

@RestController
@RequestMapping("evento")
class EventoController(
    val eventoService: EventoService
) {

    @GetMapping
    fun consultar() = ResponseEntity.ok(eventoService.consultarEventos())

    @PostMapping
    fun salvar(@RequestBody @Valid evento: EventoRequestDTO) = ResponseEntity(eventoService.salvar(evento), HttpStatus.CREATED)

    @PutMapping
    fun atualizar(@RequestBody @Valid evento: EventoRequestDTO) = ResponseEntity(eventoService.salvar(evento), HttpStatus.OK)

    @DeleteMapping("/{id}")
    fun remover(@PathVariable("id", required = true) id: String) = ResponseEntity(eventoService.remover(id), HttpStatus.NO_CONTENT)

    @PostMapping("/adicionar-atividade")
    fun adicionarAtividade(@RequestBody @Valid atividade: AtividadeRequestDTO) =
        ResponseEntity(eventoService.salvarAtividade(atividade), HttpStatus.CREATED)

    @PutMapping("/atualizar-atividade")
    fun atualizarAtividade(@RequestBody @Valid atividade: AtividadeRequestDTO) =
        ResponseEntity(eventoService.salvarAtividade(atividade), HttpStatus.OK)

    @DeleteMapping("/remover-atividade/{id}")
    fun removerAtividade(@PathVariable("id", required = true) idAtividade: String) =
        ResponseEntity(eventoService.removerAtividade(idAtividade), HttpStatus.NO_CONTENT)
}