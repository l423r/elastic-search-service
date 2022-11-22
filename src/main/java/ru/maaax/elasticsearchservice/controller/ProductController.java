package ru.maaax.elasticsearchservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.maaax.elasticsearchservice.dto.ProductDto;
import ru.maaax.elasticsearchservice.entity.Product;
import ru.maaax.elasticsearchservice.service.ProductService;

import java.util.List;

@RestController()
@RequestMapping("/product")
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

        return productService.findByName(search, pageable);
    }

    @GetMapping("/find/all")
    public Page<Product> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @GetMapping("/search/name")
    public Page<Product> searchByName(@RequestParam String name,
                                      Pageable pageable) {

        return productService.findByName(name, pageable);
    }


    @PostMapping("/add")
    public Product addToSearch(@RequestBody ProductDto request) {
        return productService.save(request);
    }

    @PostMapping("/add/all")
    public Iterable<Product> addAllToSearch(@RequestBody List<ProductDto> productDtoList) {
        return productService.saveAll(productDtoList);
    }

    @DeleteMapping("/remove")
    public void removeAll() {
        productService.deleteAll();
    }
}
