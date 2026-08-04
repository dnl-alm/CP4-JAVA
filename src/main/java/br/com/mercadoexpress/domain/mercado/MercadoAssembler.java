package br.com.mercadoexpress.domain.mercado;

import br.com.mercadoexpress.controller.MercadoController;
import br.com.mercadoexpress.dto.response.MercadoResponse;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MercadoAssembler {

    public EntityModel<MercadoResponse> toModel(MercadoResponse mercadoResponse) {
        return EntityModel.of(mercadoResponse,
                linkTo(methodOn(MercadoController.class).pesquisarPorId(mercadoResponse.id())).withSelfRel(),
                linkTo(methodOn(MercadoController.class).atualizar(mercadoResponse.id(), null)).withRel("atualizar"),
                linkTo(methodOn(MercadoController.class).deletar(mercadoResponse.id())).withRel("deletar")
        );
    }

}
