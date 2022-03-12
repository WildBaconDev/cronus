package br.com.dg.panteao.cronus.service

import br.com.dg.panteao.cronus.model.Categoria
import br.com.dg.panteao.cronus.repository.CategoriaRepository
import org.springframework.stereotype.Service
import org.springframework.util.MultiValueMap

@Service
class CategoriaService(
    val categoriaRepository: CategoriaRepository
) {
    fun salvar(categoria: Categoria): Categoria = categoriaRepository.save(categoria)
    fun consultarCategorias() = categoriaRepository.findAll()
    fun findById(id: String) = categoriaRepository.findById(id)
    fun remover(id: String) = categoriaRepository.deleteById(id)

}
