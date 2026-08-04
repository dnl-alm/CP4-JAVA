package br.com.mercadoexpress.controller;

import br.com.mercadoexpress.domain.mercado.MercadoAssembler;
import br.com.mercadoexpress.dto.request.MercadoRequest;
import br.com.mercadoexpress.dto.response.MercadoResponse;
import br.com.mercadoexpress.service.MercadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mercado")
public class MercadoController {

    private final MercadoService mercadoService;
    private final MercadoAssembler mercadoAssembler;

    @PostMapping
    public ResponseEntity<MercadoResponse> criar(MercadoRequest mercadoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mercadoService.criar(mercadoRequest));
    }

    @GetMapping
    public ResponseEntity<List<MercadoResponse>> listarTudo() {
        return ResponseEntity.ok(mercadoService.listarTudo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<MercadoResponse>> pesquisarPorId(@PathVariable Long id) {
        var mercado = mercadoService.pesquisarPorId(id);
        return ResponseEntity.ok(mercadoAssembler.toModel(mercado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<MercadoResponse>> atualizar(@PathVariable Long id, MercadoRequest mercadoRequest) {
        var mercado = mercadoService.atualizar(id, mercadoRequest);
        return ResponseEntity.ok(mercadoAssembler.toModel(mercado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        mercadoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
