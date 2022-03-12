package br.com.dg.panteao.cronus.service

import br.com.dg.panteao.cronus.model.Categoria
import br.com.dg.panteao.cronus.repository.CategoriaRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.util.MultiValueMap
import java.util.*

@Service
class CategoriaService(
    val categoriaRepository: CategoriaRepository
) {
    val logger = LoggerFactory.getLogger(CategoriaService::class.java)

    fun salvar(categoria: Categoria): Categoria {
        logger.info("id={}, nome={}", categoria.id, categoria.nome)

        return categoriaRepository.save(categoria)
    }
    fun consultarCategorias(): List<Categoria> {
        logger.info("")
        return categoriaRepository.findAll()
    }
    fun findById(id: String): Optional<Categoria> {
        logger.info("id={}", id)
        return categoriaRepository.findById(id)
    }
    fun remover(id: String) {
        logger.info("id={}", id)
        categoriaRepository.deleteById(id)
    }

}
