package br.com.mercadoexpress.dto.request;

public record MercadoRequest(
        String nome,
        String tipo,
        String setor,
        Double tamanho,
        Double preco
) {
}
