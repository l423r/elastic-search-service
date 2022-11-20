package ru.maaax.elasticsearchservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.maaax.elasticsearchservice.dto.ProductDtoRequest;
import ru.maaax.elasticsearchservice.entity.Product;
import ru.maaax.elasticsearchservice.service.ProductService;

import java.util.List;

@RestController("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public Product get(@PathVariable String id) {
        return productService.findOne(id);
    }

    @GetMapping("/search")
    public Page<Product> search(@RequestParam String search,
                                Pageable pageable) {

        return productService.findByNameOrDescription(search, search, pageable);
    }

    @GetMapping("/search/name")
    public Page<Product> searchByName(@RequestParam String search,
                                      Pageable pageable) {

        return productService.findByName(search, pageable);
    }


    @GetMapping("/add")
    public Product addToSearch(@RequestBody ProductDtoRequest request) {
        return productService.save(request);
    }

    @GetMapping("/addAll")
    public Iterable<Product> addAllToSearch(@RequestBody List<ProductDtoRequest> request) {
        return productService.saveAll(request);
    }

    @DeleteMapping("/remove")
    public void removeAll() {
        productService.deleteAll();
    }
}
