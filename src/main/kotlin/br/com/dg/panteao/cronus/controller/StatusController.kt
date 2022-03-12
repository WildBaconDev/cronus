package br.com.dg.panteao.cronus.controller

import br.com.dg.panteao.cronus.model.Status
import br.com.dg.panteao.cronus.service.StatusService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("status")
class StatusController(
    val statusService: StatusService
) {

    @GetMapping
    fun consultar() = ResponseEntity.ok(statusService.consultarStatus())

    @PostMapping
    fun salvar(@RequestBody status: Status) = ResponseEntity(statusService.salvar(status), HttpStatus.CREATED)

    @PutMapping
    fun atualizar(@RequestBody status: Status) = ResponseEntity(statusService.salvar(status), HttpStatus.CREATED)

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable("id") id: String) = ResponseEntity(statusService.remover(id), HttpStatus.NO_CONTENT)
}