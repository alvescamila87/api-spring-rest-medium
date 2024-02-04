package com.camila.springrestapi.controller;

import com.camila.springrestapi.dto.ProductDTO;
import com.camila.springrestapi.model.Product;
import com.camila.springrestapi.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity searchProduct() {
        var listProduct = productRepository.findAll();
        return ResponseEntity.ok(listProduct);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Valid ProductDTO productDTO) {
        Product newProduct = new Product(productDTO);
        newProduct = productRepository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateProduct(@PathVariable String id, @Valid ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(!optionalProduct.isEmpty()) {
            Product updateProduct = optionalProduct.get();
            updateProduct.setCategoria(productDTO.descricao());
            updateProduct.setDescricao(productDTO.descricao());
            updateProduct.setValor(productDTO.valor());
            return ResponseEntity.ok(updateProduct);
        }
        return ResponseEntity.notFound().build();
    }
}
