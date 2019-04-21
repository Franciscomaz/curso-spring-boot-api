package com.learning.cursomc.store.resource.categoria;

import com.learning.cursomc.core.resource.EntityURIBuilder;
import com.learning.cursomc.store.application.categoria.CategoriaDto;
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
    public ResponseEntity<CategoriaDto> buscarPelo(@PathVariable("id") Long id) throws CategoriaNaoEncontrada {
        return ResponseEntity.ok(CategoriaDto.fromEntity(categoriaService.buscarPelo(id)));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<CategoriaDto>> buscarTodas(final Pageable pageable) {
        return ResponseEntity.ok(categoriaService.buscarTodas(pageable));

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CategoriaDto> criar(@Valid @RequestBody CategoriaDto representation) {
        final Categoria categoria = categoriaService.criar(Categoria.fromRepresentation(representation));
        final URI uri = EntityURIBuilder.created(categoria).build();

        return ResponseEntity
                .created(uri)
                .body(CategoriaDto.fromEntity(categoria));

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CategoriaDto> atualizar(@PathVariable("id") Long id,
                                                  @Valid @RequestBody CategoriaDto categoria) {
        categoria.setId(id);
        final Categoria categoriaAtualizada = categoriaService.atualizar(Categoria.fromRepresentation(categoria));
        return ResponseEntity.ok(CategoriaDto.fromEntity(categoriaAtualizada));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        categoriaService.deletar(categoriaService.buscarPelo(id));
        return ResponseEntity.noContent().build();
    }
}
