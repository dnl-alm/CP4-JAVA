package br.com.mercadoexpress.domain.mercado;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TDS_TB_mercado")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Mercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String tipo;

    private String setor;

    private double tamanho;

    private double preco;

}
