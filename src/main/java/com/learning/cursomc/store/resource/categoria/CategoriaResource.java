package com.learning.cursomc.store.resource.categoria;

import com.learning.cursomc.core.resource.EntityURIBuilder;
import com.learning.cursomc.store.application.categoria.CategoriaService;
import com.learning.cursomc.store.domain.categoria.Categoria;
import com.learning.cursomc.store.domain.categoria.CategoriaNaoEncontrada;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "categorias/")
public class CategoriaResource {

    private final CategoriaService categoriaService;

    public CategoriaResource(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> buscarPelo(@PathVariable("id") Long id) throws CategoriaNaoEncontrada {
        return ResponseEntity.ok(categoriaService.buscarPelo(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Categoria>> buscarTodas(final Pageable pageable) {
        return ResponseEntity.ok(categoriaService.buscarTodas(pageable));

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
        final Categoria categoriaAdicionada = categoriaService.criar(categoria);
        final URI uri = EntityURIBuilder.created(categoria).build();

        return ResponseEntity
                .created(uri)
                .body(categoriaAdicionada);

    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.atualizar(categoria));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        categoriaService.deletar(categoriaService.buscarPelo(id));
        return ResponseEntity.accepted().build();
    }
}
