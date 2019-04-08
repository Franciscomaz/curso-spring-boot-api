package com.learning.cursomc.resources.Categoria;

import com.learning.cursomc.application.Categoria.CategoriaService;
import com.learning.cursomc.domain.categoria.Categoria;
import com.learning.cursomc.domain.categoria.CategoriaNaoEncontrada;
import org.springframework.web.bind.annotation.*;

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
    public Categoria criar(@RequestBody Categoria categoria) {
        return categoriaService.criar(categoria);
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
