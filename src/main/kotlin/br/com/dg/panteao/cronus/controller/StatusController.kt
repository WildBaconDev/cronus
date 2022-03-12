package br.com.dg.panteao.cronus.controller

import br.com.dg.panteao.cronus.model.Status
import br.com.dg.panteao.cronus.service.StatusService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("status")
class StatusController(
    val statusService: StatusService
) {

    @GetMapping
    fun consultarStatus() = ResponseEntity.ok(statusService.consultarStatus())

    @PostMapping
    fun salvarStatus(@RequestBody status: Status) = ResponseEntity(statusService.salvar(status), HttpStatus.CREATED)
}