package com.learning.cursomc.store.resource.categoria;

import com.learning.cursomc.store.application.categoria.CategoriaService;
import com.learning.cursomc.store.domain.categoria.Categoria;
import com.learning.cursomc.store.domain.categoria.CategoriaNaoEncontrada;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "categorias/")
public class CategoriaResource {

    private final CategoriaService categoriaService;

    public CategoriaResource(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Categoria buscarPelo(@PathVariable("id") Long id) throws CategoriaNaoEncontrada {
        return categoriaService.buscarPelo(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> buscarTodas() {
        return categoriaService.buscarTodas();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> criar(@RequestBody Categoria categoria) {
        final Categoria categoriaAdicionada = categoriaService.criar(categoria);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id]")
                .buildAndExpand(categoriaAdicionada.getId())
                .toUri();

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(method = RequestMethod.PUT)
    public Categoria atualizar(@RequestBody Categoria categoria) {
        return categoriaService.atualizar(categoria);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Categoria deletar(@PathVariable("id") Long id) {
        return null;
    }
}
