package com.camila.springrestapi.model;

import com.camila.springrestapi.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "produto")
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer valor;

    public Product(ProductDTO productDTO) {
        this.categoria = productDTO.categoria();
        this.descricao = productDTO.descricao();
        this.valor = productDTO.valor();
    }
}
