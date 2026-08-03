package br.com.mercadoexpress.controller;

import br.com.mercadoexpress.dto.request.MercadoRequest;
import br.com.mercadoexpress.dto.response.MercadoResponse;
import br.com.mercadoexpress.service.MercadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mercado")
public class MercadoController {

    private final MercadoService mercadoService;

    @PostMapping
    public ResponseEntity<MercadoResponse> criar(MercadoRequest mercadoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mercadoService.criar(mercadoRequest));
    }

    @GetMapping
    public ResponseEntity<List<MercadoResponse>> listarTudo() {
        return ResponseEntity.ok(mercadoService.listarTudo());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MercadoResponse> atualizar(@PathVariable Long id, MercadoRequest mercadoRequest) {
        return ResponseEntity.ok(mercadoService.atualizar(id, mercadoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        mercadoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
