package com.learning.cursomc.store.resource.categoria;

import com.learning.cursomc.core.resource.EntityURIBuilder;
import com.learning.cursomc.store.application.categoria.CategoriaRepresentation;
import com.learning.cursomc.store.application.categoria.CategoriaService;
import com.learning.cursomc.store.domain.categoria.Categoria;
import com.learning.cursomc.store.domain.categoria.CategoriaNaoEncontrada;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaResource {

    private final CategoriaService categoriaService;

    public CategoriaResource(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoriaRepresentation> buscarPelo(@PathVariable("id") Long id) throws CategoriaNaoEncontrada {
        return ResponseEntity.ok(CategoriaRepresentation.fromEntity(categoriaService.buscarPelo(id)));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<CategoriaRepresentation>> buscarTodas(final Pageable pageable) {
        return ResponseEntity.ok(categoriaService.buscarTodas(pageable).map(CategoriaRepresentation::new));

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CategoriaRepresentation> criar(@Valid @RequestBody CategoriaRepresentation representation) {
        final Categoria categoria = categoriaService.criar(Categoria.fromRepresentation(representation));
        final URI uri = EntityURIBuilder.created(categoria).build();

        return ResponseEntity
                .created(uri)
                .body(CategoriaRepresentation.fromEntity(categoria));

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CategoriaRepresentation> atualizar(@PathVariable("id") Long id,
                                                             @Valid @RequestBody CategoriaRepresentation representation) {
        final Categoria categoriaAtualizada = categoriaService.atualizar(id, Categoria.fromRepresentation(representation));
        return ResponseEntity.ok(CategoriaRepresentation.fromEntity(categoriaAtualizada));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        categoriaService.deletar(categoriaService.buscarPelo(id));
        return ResponseEntity.noContent().build();
    }
}
