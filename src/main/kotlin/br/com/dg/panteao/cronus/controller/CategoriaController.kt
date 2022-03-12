package br.com.dg.panteao.cronus.controller

import br.com.dg.panteao.cronus.model.Categoria
import br.com.dg.panteao.cronus.service.CategoriaService
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
@RequestMapping("categoria")
class CategoriaController(
    val categoriaService: CategoriaService
) {

    @GetMapping
    fun consultarCategorias() = ResponseEntity.ok(categoriaService.consultarCategorias())

    @PostMapping
    fun salvar(@RequestBody categoria: Categoria) = ResponseEntity(categoriaService.salvar(categoria), HttpStatus.CREATED)

    @PutMapping
    fun atualizar(@RequestBody categoria: Categoria) = ResponseEntity.ok(categoriaService.salvar(categoria))

    @DeleteMapping("/{id}")
    fun remover(@PathVariable id: String) = ResponseEntity(categoriaService.remover(id), HttpStatus.NO_CONTENT)
}