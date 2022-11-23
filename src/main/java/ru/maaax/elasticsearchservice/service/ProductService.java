package ru.maaax.elasticsearchservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.maaax.elasticsearchservice.dto.ProductDto;
import ru.maaax.elasticsearchservice.entity.Product;

public interface ProductService {

    Product save(ProductDto productDto);

    Iterable<Product> saveAll(Iterable<ProductDto> products);

    void delete(Product product);

    void deleteAll();

    void deleteById(String id);

    Product findOne(String id);

    Page<Product> findAll(Pageable pageRequest);

    Page<Product> findByName(String name, Pageable pageRequest);

    Long getCount();
}
