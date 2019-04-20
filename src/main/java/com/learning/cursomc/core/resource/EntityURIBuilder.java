package com.learning.cursomc.core.resource;

import com.learning.cursomc.core.domain.Entidade;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class EntityURIBuilder {

    private Entidade entidade;
    private final UriComponentsBuilder uriComponentsBuilder;

    private EntityURIBuilder(final UriComponentsBuilder uriComponentsBuilder) {
        this.uriComponentsBuilder = uriComponentsBuilder;
    }

    public static EntityURIBuilder created(final Entidade entidade) {
        return new EntityURIBuilder(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}"))
                .withEntity(entidade);
    }

    public EntityURIBuilder withEntity(final Entidade entidade) {
        this.entidade = entidade;
        return this;
    }

    public URI build() {
        return this.uriComponentsBuilder
                .buildAndExpand(entidade.getId())
                .toUri();
    }
}
